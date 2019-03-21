package org.syaku.toy.scheduler.support;

/**
 * @author Seok Kyun. Choi.
 * @since 2019-03-20
 */

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.syaku.toy.scheduler.support.job.BasicJob;
import org.syaku.toy.scheduler.support.job.SpringBeanJob;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class SchedulerTest {
    @Autowired
    private Scheduler scheduler;

    @After
    public void after() throws Exception {
        Thread.sleep(1000);
    }

    private JobDetail jobDetail(String name) {
        return JobBuilder.newJob()
            .ofType(BasicJob.class)
            .storeDurably()
            .withIdentity(name + "_job")
            .withDescription("basic_job ...")
            .build();
    }

    private JobDetail beanJobDetail(String name) {
        return JobBuilder.newJob()
            .ofType(SpringBeanJob.class)
            .storeDurably()
            .withIdentity(name + "_job")
            .withDescription("bean_job ...")
            .build();
    }

    private Trigger trigger(String name) {
        return TriggerBuilder.newTrigger()
            .withIdentity(name + "_trigger")
            .withDescription("test_trigger ...")
            .withSchedule(
                SimpleScheduleBuilder.simpleSchedule().repeatForever().withIntervalInMilliseconds(1000))
            .build();
    }

    @Test
    public void 일반_테스트() throws Exception {
        scheduler.scheduleJob(jobDetail("basic"), trigger("basic"));
    }

    @Test
    public void 스프링빈_테스트() throws Exception {
        scheduler.scheduleJob(beanJobDetail("bean"), trigger("bean"));
    }

    @Test
    public void 여러작업_테스트() throws Exception {
        scheduler.scheduleJob(jobDetail("basic2"), trigger("basic2"));
        scheduler.scheduleJob(beanJobDetail("bean2"), trigger("bean2"));
    }
}

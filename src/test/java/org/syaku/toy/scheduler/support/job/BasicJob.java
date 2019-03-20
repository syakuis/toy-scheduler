package org.syaku.toy.scheduler.support.job;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author Seok Kyun. Choi.
 * @since 2019-03-21
 */
@Slf4j
public class BasicJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.debug("basic job...");
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }
}
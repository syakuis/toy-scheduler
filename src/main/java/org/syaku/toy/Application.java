package org.syaku.toy;

/**
 * @author Seok Kyun. Choi.
 * @since 2019-03-20
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import java.util.Objects;
import java.util.TimeZone;

@SpringBootApplication
public class Application {
    @Autowired
    private Environment environment;

    @PostConstruct
    public void init(){
        System.setProperty("file.encoding", Objects.requireNonNull(environment.getProperty("app.file.encoding")));
        TimeZone.setDefault(TimeZone.getTimeZone(environment.getProperty("app.time-zone")));
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
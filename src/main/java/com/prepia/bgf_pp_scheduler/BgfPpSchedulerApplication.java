package com.prepia.bgf_pp_scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class BgfPpSchedulerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BgfPpSchedulerApplication.class, args);
    }

}

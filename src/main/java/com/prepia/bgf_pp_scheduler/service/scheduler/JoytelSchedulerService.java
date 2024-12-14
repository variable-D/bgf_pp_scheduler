package com.prepia.bgf_pp_scheduler.service.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class JoytelSchedulerService {



    @Scheduled(fixedRate = 10000)
    public void checkInventoryAndPlaceOrder() {
        log.info("스케줄러...");
    }
}

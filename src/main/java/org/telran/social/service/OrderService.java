package org.telran.social.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderService {

//    @Scheduled(cron = "0 * 9 * * ?") // from 9 to 9-59
//    public void testScheduler() {
//        System.out.println("Test one");
//    }

   // @Async("pool")
    @Scheduled(fixedDelay = 5000)
    public void testSchedulerTwo() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("Scheduler start  two {}" , Thread.currentThread().getName() );
    }

//    @Scheduled(fixedRate = 10)
//    //@Async("pool")
//    public void testSchedulerThree() {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        log.info("Scheduler start three {}" , Thread.currentThread().getName() );
//    }
}

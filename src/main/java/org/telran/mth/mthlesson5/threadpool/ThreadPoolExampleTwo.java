package org.telran.mth.mthlesson5.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExampleTwo {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(100);

        for (int i = 0; i < 9 ; i++) {
            executorService.execute(new TestPool(i+1));
        }

        Thread.sleep(5000);

        for (int i = 9; i < 18 ; i++) {
            executorService.execute(new TestPool(i+1));
        }

    }
}

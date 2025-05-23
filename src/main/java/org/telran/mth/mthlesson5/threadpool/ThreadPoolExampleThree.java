package org.telran.mth.mthlesson5.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExampleThree {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 200 ; i++) {
            executorService.execute(new TestPool(i+1));
        }

        Thread.sleep(1200000);
    }
}

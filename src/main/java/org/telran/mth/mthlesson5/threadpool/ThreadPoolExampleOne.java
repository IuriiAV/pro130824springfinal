package org.telran.mth.mthlesson5.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExampleOne {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for(int i = 0; i < 3; i++) {
            executorService.execute(new TestPool(i+1));
        }

        executorService.shutdown();
    }
}

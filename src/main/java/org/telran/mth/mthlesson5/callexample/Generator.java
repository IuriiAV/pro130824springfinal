package org.telran.mth.mthlesson5.callexample;

import java.util.concurrent.Callable;

public class Generator implements Callable<String> {

    //long count = 100_000_000_000l;

    @Override
    public String call() throws Exception {
        Thread.sleep(10000);
        return Thread.currentThread().getName() + " Hello from callable";
    }
}

package org.telran.mth.mthlesson1.finishexample;

public class StopClass implements Runnable{

    @Override
    public void run() {
        System.out.println("Start " + Thread.currentThread().getName());
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            //
        }
        System.out.println("End " + Thread.currentThread().getName());
    }
}

package org.telran.mth.mthlesson1.summ;

public class Sum implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            //synchronized (SumApp.class) {
                SumApp.result.getAndIncrement(); // 1) read value, 2) increase value; 3) write value

                System.out.println("" + Thread.currentThread().getName()
                        + " " + "i=" + i + " " + +SumApp.result.get());
            //}
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

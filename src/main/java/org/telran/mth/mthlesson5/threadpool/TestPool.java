package org.telran.mth.mthlesson5.threadpool;

public class TestPool implements Runnable {

    private final int taskNumber;

    public TestPool(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        for (int i = 0; i < 300; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(taskNumber + " " + name + " " + i);
        }
    }
}

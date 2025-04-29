package org.telran.mth.mthlesson4;

import lombok.SneakyThrows;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock implements Runnable {

    private final List<Integer> list;

    private Lock lock = new ReentrantLock();

    public TestLock(List<Integer> list) {
        this.list = list;
    }

    @SneakyThrows
    @Override
    public void run() {

        boolean isFree = lock.tryLock(15000, TimeUnit.MILLISECONDS);
        //lock.lock();
        // try {
        if (isFree) {
            for (int i = 0; i < 100; i++) {
                list.add(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            if (Thread.currentThread().getName().contains("0")) {
                throw new IllegalArgumentException();
            }
            // } finally {
            lock.unlock();
            // }
        }
    }
}

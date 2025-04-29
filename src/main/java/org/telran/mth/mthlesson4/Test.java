package org.telran.mth.mthlesson4;

import java.util.List;

public class Test implements Runnable {

    private final List<Integer> list;

    public Test(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start");
        print();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        printBye();
        System.out.println(Thread.currentThread().getName() + " stop");
    }

    private void print() {
        System.out.println(Thread.currentThread().getName() + " start print");
        synchronized (list) {
            System.out.println(Thread.currentThread().getName() + " print");
            for (int i = 0; i < 100; i++) {
                list.add(i);
            }
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private synchronized void printBye() {
        System.out.println(Thread.currentThread().getName() + " bye");
    }
}

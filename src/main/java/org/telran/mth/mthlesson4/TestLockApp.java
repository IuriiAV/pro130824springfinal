package org.telran.mth.mthlesson4;

import java.util.ArrayList;
import java.util.List;

public class TestLockApp {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new ArrayList<>();
        TestLock testLock = new TestLock(list);

        Thread thread = new Thread(testLock);
        Thread thread1 = new Thread(testLock);

        thread.start();
        Thread.sleep(1000);

        thread1.start();

        Thread.sleep(2000);

        System.out.println("" + thread.getName() +" "+ thread.getState());
        System.out.println("" + thread1.getName() +" "+ thread1.getState());



        Thread.sleep(15000);

        System.out.println("" + thread.getName() +" "+ thread.getState());
        System.out.println("" + thread1.getName() +" "+ thread1.getState());

        thread1.join();
        thread.join();

        System.out.println("Size " + list.size());
    }
}

package org.telran.mth.mthlesson6;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class WNExample {



    public static void main(String[] args) throws InterruptedException {
        Queue<Integer> queue = new LinkedList<>();
        Producer producer = new Producer(queue);
        Thread thread = new Thread(producer);
        thread.start();

        Consumer consumer = new Consumer(queue);
        Thread thread1 = new Thread(consumer);
        thread1.start();

        Thread.sleep(10000);
        System.out.println(thread.getState());
        System.out.println(thread1.getState());

    }
}

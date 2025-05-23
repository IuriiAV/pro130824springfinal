package org.telran.mth.mthlesson6;

import java.util.Queue;

public class Producer implements Runnable {

    private final Queue<Integer> queue;

    public Producer(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        while (true) {
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }

            synchronized (queue) {
                if (queue.size() == 3) {
                    try {
                        queue.notify();
                        queue.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                queue.add(1000);
            }
            System.out.println("" + Thread.currentThread().getName() + " add element to queue");

        }
    }
}

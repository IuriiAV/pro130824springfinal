package org.telran.mth.mthlesson6;

import java.util.Queue;

public class Consumer implements Runnable {

    private final Queue<Integer> queue;

    public Consumer(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
//            try {
//                //Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            synchronized (queue) {
                if (!queue.isEmpty()) {
                    queue.poll();
                    System.out.println("" + Thread.currentThread().getName() + " get element from queue");
                } else {
                    try {
                        queue.notify();
                        queue.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }


        }
    }
}

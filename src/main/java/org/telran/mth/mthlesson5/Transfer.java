package org.telran.mth.mthlesson5;

import java.util.Queue;

public class Transfer implements Runnable {

    private final Queue<Integer> from;

    private final Queue<Integer> to;

    public Transfer(Queue<Integer> from, Queue<Integer> integers) {
        this.from = from;
        to = integers;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            synchronized (from) {  // monitor from Thread - 0 // Thread - 0 monitor to
                int value = from.poll(); // from , to  //  to - blocked, from - blocked
                synchronized (to) { // monitor to Thread - 0 // Thread - 0 monitor from
                    to.add(value);
                    System.out.println(Thread.currentThread().getName() +
                            " transfer value " + value);
                } //release to Thread-0
            } //release from Thread-0
        }
    }
}

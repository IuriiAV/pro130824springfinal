package org.telran.mth.mthlesson2;

import java.util.List;

public class ListCreator implements Runnable {

    private List<Integer> list;

    public ListCreator(List<Integer> list) {
        this.list = list;
    }

    @Override
    public  void run() {  // new ListCreator
        for (int i = 0; i < 100; i++) {
         //  synchronized (list) {  // new ListCreator
                list.add(i);
         //   }
            sleep(2);
        }
    }


    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

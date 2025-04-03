package org.telran.mth.mthlesson1;

public class Printer extends Thread {

    @Override
    public void run() {
        System.out.println("    Start method run");
        System.out.println("    Method run : thread name : " + Thread.currentThread().getName());

        for (int i = 0; i < 100; i++) {
            System.out.println("Method run : thread name : "
                    + Thread.currentThread().getName() + " " + i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                //
            }
        }
//
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException exception) {
//            //
//        }

        System.out.println("    End method run");
    }
}
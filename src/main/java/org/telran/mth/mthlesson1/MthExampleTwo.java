package org.telran.mth.mthlesson1;

public class MthExampleTwo {

    public static void main(String[] args) {
        System.out.println("Start method main ");

        Runnable runnable = () -> {
            System.out.println("Thread name is " + Thread.currentThread().getName());
        };

        new Thread(runnable).start();

        System.out.println("End method main ");
    }
}

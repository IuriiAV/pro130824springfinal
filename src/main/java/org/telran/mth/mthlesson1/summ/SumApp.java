package org.telran.mth.mthlesson1.summ;

public class SumApp {

    public static int result = 0;

    public static void main(String[] args) throws InterruptedException {
        Sum sum = new Sum();

        Thread thread = new Thread(sum);
        Thread thread1 = new Thread(sum);
        Thread thread2 = new Thread(sum);

        thread.start();
        thread1.start();
        thread2.start();

        thread.join();
        thread1.join();
        thread2.join();

        System.out.println("Result = " + result);
    }
}

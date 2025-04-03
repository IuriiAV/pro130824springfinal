package org.telran.mth.mthlesson1.finishexample;

public class StopApp {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start " + Thread.currentThread().getName());

        StopClass stopClass = new StopClass();
        Thread thread = new Thread(stopClass);
        System.out.println("State 1 : " + thread.getState());

        thread.start();
        System.out.println("State 2 : " + thread.getState());

        Thread.sleep(5000);
        System.out.println("State 3 : " + thread.getState());


        thread.join(); // позволяет усыпить поток который его вызвал, до того момента
        // пока не завершится поток , у которого он вызван

        System.out.println("State 4 : " + thread.getState());

        System.out.println("End " + Thread.currentThread().getName());
    }
}

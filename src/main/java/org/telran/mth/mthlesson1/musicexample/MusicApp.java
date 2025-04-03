package org.telran.mth.mthlesson1.musicexample;

public class MusicApp {

    public static boolean isWork = true;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start method main ----------------------------");

        MusicThread musicThread = new MusicThread();
        Thread thread = new Thread(musicThread);
        thread.start();


        Thread.sleep(10000);
        // thread.stop(); - просто грохает поток, мы не знаем чем занят поток
        isWork = false;
        System.out.println("End method main ----------------------------");
    }
}

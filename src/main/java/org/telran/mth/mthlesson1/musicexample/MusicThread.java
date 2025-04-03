package org.telran.mth.mthlesson1.musicexample;

import java.time.LocalTime;

public class MusicThread implements Runnable {

    @Override
    public void run() {
        while (MusicApp.isWork) {
            pause(2000);
            System.out.println("Play music : time : " + System.currentTimeMillis());
        }
    }

    private void pause(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            //
        }
    }
}

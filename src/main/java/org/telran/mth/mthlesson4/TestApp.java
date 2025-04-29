package org.telran.mth.mthlesson4;

import java.util.ArrayList;
import java.util.List;

public class TestApp {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> testList = new ArrayList<>();

        Test test = new Test(testList);  // mutex test
        Test test1 = new Test(testList); // mutex test1
        Test test2 = new Test(testList); // mutex test1

        Thread thread0 = new Thread(test);
        Thread thread1 = new Thread(test1);
        Thread thread2 = new Thread(test2);
        thread0.setPriority(1);
        thread1.setPriority(10);
        thread2.setPriority(10);

        thread0.start();
        thread1.start();
        thread2.start();

        Thread.sleep(3000);


        System.out.println(" " + thread0.getName() + " "+ thread0.getState());
        System.out.println(" " + thread1.getName() + " "+ thread1.getState());
        System.out.println(" " + thread2.getName() + " "+ thread2.getState());

        thread2.join();
        thread0.join();
        thread1.join();

        System.out.println("List size = " + testList.size());
    }
}

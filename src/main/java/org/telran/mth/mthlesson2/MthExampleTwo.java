package org.telran.mth.mthlesson2;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class MthExampleTwo {

    public static void main(String[] args) throws Exception{
        List<Integer> one = new ArrayList<>();

        ListCreator listCreator = new ListCreator(one);
        Thread thread = new Thread(listCreator);

        ListCreator listCreator1 = new ListCreator(one);
        Thread thread1 = new Thread(listCreator1);

        thread.start();
        thread1.start();

        thread.join();
        thread1.join();

        System.out.println("Size = " + one.size());
    }
}

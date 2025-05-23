package org.telran.mth.mthlesson5;

import java.util.ArrayDeque;
import java.util.Queue;

public class TransferApp {

    public static void main(String[] args) {
        Queue<Integer> one = new ArrayDeque<>();

        Queue<Integer> two = new ArrayDeque<>();


        for(int i = 0; i < 2000; i++) {
            one.add(i);
            two.add(i);
        }

        Transfer transfer = new Transfer(one ,two);
        Transfer transfer1 = new Transfer(two ,one);

        new Thread(transfer).start();
        new Thread(transfer1).start();

    }
}

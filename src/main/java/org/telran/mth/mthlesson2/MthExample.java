package org.telran.mth.mthlesson2;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * Mutex - специальный объект, который есть у каждого  объекта в Java
 * (флаг - занят или свободен), доступ у нему имеет JVM
 *
 * Monitor - механизм взаимодействия с мьютексом объекта
 *
 * synchronized -  команда для взаимодействия с монитором
 *
 */
public class MthExample {

    public static int result = 0;

    public static AtomicInteger result2 = new AtomicInteger(0);

    public static void main(String[] args) throws Exception {
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

        System.out.println("Result = " + result2.get());
    }
}

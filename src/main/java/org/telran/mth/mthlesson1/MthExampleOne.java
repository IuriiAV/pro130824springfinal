package org.telran.mth.mthlesson1;

/**
 * Процесс - экземпляр выполняемого приложения (выделена память и процессорное время)
 * Поток - базовая единица выполнения кода (программы)
 * <p>
 * По умолчанию, любой процесс состоит из 1 потока
 * Один процесс , может состоять из 1 и более потоков
 * <p>
 * В Java поток нашего приложения назвывается главным потоком и его имя main(не путать
 * с методом main)
 * <p>
 * Thread - главный класс для работы с потоками
 * MthExampleOne :
 * Создан Процесс :
 * Создан Поток main :
 * Поток main :
 * Запустил метод main
 * Завершил метод main
 * Остановился поток main
 * Остановился процесс:
 * <p>
 * В Java есть два способа создать поток :
 * Thread -
 * 1) отнаследоваться от класса Thread
 * 2) переопределить метод run,
 * 3) запустить метод run через команду start() у класса Thread
 *
 * Runnable
 * 1) имплементировать интерфейс Runnable
 * 2) переопределить метод run,
 * 3) запустить метод run через команду start() у класса Thread
 */
public class MthExampleOne {

    public static void main(String[] args) {
        System.out.println("Start method main");
        System.out.println("Method main : thread name : " + Thread.currentThread().getName());

        Printer printer = new Printer();
        //printer.run();

//        Thread thread = new Thread(printer);
//        thread.start(); // запуск нового потока, который выполнит код в классе printer в методе run

        printer.start();

        Thread thread1 = new Thread(new PrinterTwo());
        thread1.start();

        print();
        System.out.println("End method main");
    }

    public static void print() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Method print : thread name : "
                    + Thread.currentThread().getName() + " " + i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                //
            }
        }
    }
}

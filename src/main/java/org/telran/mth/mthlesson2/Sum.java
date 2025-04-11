package org.telran.mth.mthlesson2;

import org.telran.mth.mthlesson1.summ.SumApp;

public class Sum implements Runnable {

    //synchronized(метод) - если с этим объектом никто не работает, то поток
    //блокирует мьютекс объекта и начинат выполнять этот метод
    //блокировка будет до тех пор , пока поток не закончит метод и после отпустит
    //мьютекс объкта

    //если в тот момент, когда объект заблокирован и синхронизированный метод пытается
    //выполнить другой поток, то этот поток уйдет в состояни ожидания, до разблокировки
    //мьютекса этого объекта

    @Override
    public void run() {  //synchronized in signature == synchronized(this) Sum object
        for (int i = 0; i < 1000; i++) {
           // synchronized (this) {  // Sum object
                //MthExample.result++; // 1) read value, 2) increase value; 3) write value
            MthExample.result2.getAndIncrement();
          //  }
                System.out.println("" + Thread.currentThread().getName()
                        + " " + "i=" + i + " " + +MthExample.result2.get());

            sleep();
        }
    }

    private static void sleep() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

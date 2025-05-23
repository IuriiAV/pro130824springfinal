package org.telran.mth.mthlesson5.callexample;

import java.util.concurrent.*;

/*
Runnable - run (void, no exception)

Callable - call(<T> , throws exceptions)  // async

String method();

String result = method(); // sync

Generator gen = new Generator();
String result = new Thread(gen).start(); !!!!!

Future - get result from Callable
 */
public class CallApp {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Generator generator = new Generator();
        FutureTask<String> task = new FutureTask<>(generator);

        //Runnable - new Thread(Runnable)
        //Callable - new Thread(Future(Callable))

        new Thread(task).start(); // async

        String result = null;
        try {
            result = task.get(20000, TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            result = "Result not exists";
        }

        System.out.println("Result is " + result);
    }
}

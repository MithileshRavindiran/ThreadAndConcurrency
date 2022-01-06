package com.example.threads.future;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureAndCallableExample {

    public static void main(String args[]) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<String> responsefromTask1 = executorService.submit(() -> {
            System.out.println("Inside callable  on thread name:" + Thread.currentThread().getName());
            System.out.println("Task 1 started at"+ LocalDateTime.now());
            Thread.sleep(2000);
            System.out.println("Task 1 finished at"+ LocalDateTime.now());
            return "Hello World";
        });

        Future<String> responsefromTask2 =executorService.submit(() -> {
            System.out.println("Inside callable on thread name:" + Thread.currentThread().getName());
            System.out.println("Task 2 started at"+ LocalDateTime.now());
            Thread.sleep(3000);
            System.out.println("Task 2 finished at"+ LocalDateTime.now());
            return "Hello World Again";
        });

        System.out.println(responsefromTask2.get());
        System.out.println(responsefromTask1.get());


        executorService.shutdown();

    }
}

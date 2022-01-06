package com.example.threads.future;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.*;

public class FutureInvokeAllExample {

    public static void main(String args[]) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Callable<String> task1 = () -> {
            Thread.sleep(5000);
            return "Message from First task";
        };


        Callable<String> task2 = () -> {
            Thread.sleep(1000);
            return "Message from Second task";
        };


        Callable<String> task3 = () -> {
            Thread.sleep(3000);
            return "Message from Third task";
        };

        List<Callable<String>> callableList = List.of(task1, task2, task3);

        System.out.println("All futures submitted at"+ LocalDateTime.now());
        List<Future<String>> futureList = executorService.invokeAll(callableList);

        futureList.forEach(future -> {
            // The result is printed only after all the futures are complete. (i.e. after 5 seconds)
            try {
                System.out.println("futures being retrieved  at"+ LocalDateTime.now());
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

        executorService.shutdown();
    }
}

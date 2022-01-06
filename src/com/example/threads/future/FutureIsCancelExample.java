package com.example.threads.future;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.*;

public class FutureIsCancelExample {

    public static void main(String args[]) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        System.out.println("Creating callable");

        Callable task = () -> {
            Thread.sleep(5000);
            return "Hello World after 5 seconds";
        };

        System.out.println("Submitting callable");
        LocalDateTime startTime = LocalDateTime.now();
        System.out.println("task submited at"+ startTime);
        Future<String> taskFuture = executorService.submit(task);

        while(!taskFuture.isDone()) {
            System.out.println("Task is still running");
            Thread.sleep(1000);
           Duration duration = Duration.between(startTime, LocalDateTime.now());
           if(duration.toSeconds() > 3) {
               taskFuture.cancel(true);
           }
        }

        if(!taskFuture.isCancelled()) {
            System.out.println("Task completed! Retrieving the result");
            // Future.get() blocks until the result is available
            String result = taskFuture.get();
            System.out.println(result);
        } else {
            System.out.println("Task was cancelled");
        }


        executorService.shutdown();
    }
}

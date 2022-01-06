package com.example.threads.future;

import java.time.LocalDateTime;
import java.util.concurrent.*;

public class FutureIsDoneExample {

    public static void main(String args[]) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        System.out.println("Creating callable");
        System.out.println("started at"+ LocalDateTime.now());
        Callable task = () -> {
            Thread.sleep(5000);
            return "Hello World after 5 seconds";
        };

        System.out.println("Submitting callable");
        Future<String> taskFuture = executorService.submit(task);

        while(!taskFuture.isDone()) {
            System.out.println("Task is still running");
            Thread.sleep(500);
        }


        System.out.println("finished at"+ LocalDateTime.now());
        System.out.println("Task Completed and the result is" + taskFuture.get());

        executorService.shutdown();
    }
}

package com.example.threads.threadpool;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledPeriodicExecutorExample {

    public static void main(String args[]) throws InterruptedException {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);

        executorService.scheduleAtFixedRate(() -> {
            System.out.println("Executing task at:"+ LocalDateTime.now());
        },0, 2, TimeUnit.SECONDS);
        System.out.println("Making the  main thread to sleep for 10000 ms after that executor service will be shutdown");
        Thread.sleep(10000);

        System.out.println("Shutting down the executor service after the sleep time");
        executorService.shutdown();
    }
}

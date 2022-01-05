package com.example.threads.threadpool;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorExample {

    public static void main(String args[]) {
        System.out.println("Inside:" + Thread.currentThread().getName());
        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(2);

        System.out.println("Time at time of starting of the scheduled thread:"+ LocalDateTime.now());
        threadPool.schedule(() -> {
            System.out.println("Entered thread task 1"+ Thread.currentThread().getName()+ "at time:" + LocalDateTime.now());
        }, 5, TimeUnit.SECONDS);

        threadPool.shutdown();
    }
}

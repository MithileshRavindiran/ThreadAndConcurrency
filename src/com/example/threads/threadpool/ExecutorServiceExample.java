package com.example.threads.threadpool;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecutorServiceExample {

    public static void main(String arg[]) {
        System.out.println("Inside : " + Thread.currentThread().getName());

        System.out.println("Creating Executor Service with a thread pool of Size 2");
        ExecutorService threadPool = Executors.newFixedThreadPool(2);

        threadPool.submit(() -> {
            System.out.println("Executing task 1 inside:" + Thread.currentThread().getName() + "at time" + LocalDateTime.now());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Exited task 1 at time:" + LocalDateTime.now());
        });

        threadPool.submit(() -> {
            System.out.println("Executing task 2 inside:" + Thread.currentThread().getName() + "at time" + LocalDateTime.now());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Exited task 2 at time:" + LocalDateTime.now());
        });

        threadPool.submit(() -> {
            System.out.println("Executing task 3 inside:" + Thread.currentThread().getName() + "at time" + LocalDateTime.now());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Exited task 3 at time:" + LocalDateTime.now());
        });

        threadPool.shutdown();

    }
}

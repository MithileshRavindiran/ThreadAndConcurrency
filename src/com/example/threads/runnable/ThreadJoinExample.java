package com.example.threads.runnable;

import java.time.LocalDateTime;

public class ThreadJoinExample {

    public static void main(String args[]) {
        Thread thread1 = new Thread(() -> {
            System.out.println("Entered Thread 1 at"+ LocalDateTime.now());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            System.out.println("Exited Thread 1 at"+ LocalDateTime.now());
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("Entered Thread 2 at"+ LocalDateTime.now());
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
               throw new IllegalStateException(e);
            }
            System.out.println("Exited Thread 2 at"+ LocalDateTime.now());
        });

        System.out.println("Starting Thread 1");
        thread1.start();

        System.out.println("Making Thread 1 to wait for complete at 1000 ms");
        try {
            thread1.join(3000);
        } catch (InterruptedException e) {
           throw new IllegalStateException(e);
        }

        System.out.println("Waited enough! Starting Thread 2 now");
        thread2.start();
    }
}

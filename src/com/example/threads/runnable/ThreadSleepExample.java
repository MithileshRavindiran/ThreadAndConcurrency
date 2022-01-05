package com.example.threads.runnable;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class ThreadSleepExample {

    public static void main(String arg[]) {
        List<String> messages = Arrays.asList("Mithilesh will achieve big",
                "This year am gonna achieve a lot",
                "I will work hard to get placed in a product company",
                "I will spend sometime to learn and equip myself every day",
                "All will be good and I 'll be doing good to others too");

        Thread thread1 = new Thread(() -> {
            messages.forEach(messsage -> {
                System.out.println(LocalDateTime.now());
                System.out.println(messsage);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                   throw new IllegalStateException(e);
                }
            });
        });

        thread1.start();
    }
}

package com.example.threads.runnable;

public class RunnableExample implements Runnable{

   public static void main(String args[]) {
       System.out.println("Current Thread Name:" + Thread.currentThread().getName());
       RunnableExample runnableExample = new RunnableExample();

       System.out.println("Creating Thread");
       Thread thread = new Thread(runnableExample);

       System.out.println("Starting Thread");
       thread.start();
   }

    @Override
    public void run() {
        System.out.println("Thread Name:" + Thread.currentThread().getName());
    }
}

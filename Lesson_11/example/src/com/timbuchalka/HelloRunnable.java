package com.timbuchalka;

public class HelloRunnable implements Runnable {
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        String helloMsg = String.format("Hello, i'm %s helloRunnable", threadName);
        System.out.println(helloMsg);
    }
}

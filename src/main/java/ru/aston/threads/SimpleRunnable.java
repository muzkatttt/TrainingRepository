package ru.aston.threads;

public class SimpleRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Hello from runnable:" + Thread.currentThread().getName());
    }
}

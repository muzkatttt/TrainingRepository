package ru.aston.threads.practice;

public class Task21 implements Runnable{
    @Override
    public void run() {
        int count = 0;
        for (int i = 0; i < 100; i++) {
            System.out.println("на экране " + Thread.currentThread().getName());
            count++;
            System.out.println(count);
        }

    }
}

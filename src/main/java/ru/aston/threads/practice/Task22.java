package ru.aston.threads.practice;

public class Task22 extends Thread {
    public Task22() {
    }

    @Override
    public void run() {
        int count = 0;
        for (int i = 0; i < 100; i++) {
            System.out.println("Поток " + Thread.currentThread().threadId() + " запущен в " + i + " раз");
            count++;
        }
        System.out.println(count);
    }
}

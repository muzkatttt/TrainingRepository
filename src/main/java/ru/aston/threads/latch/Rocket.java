package ru.aston.threads.latch;

import java.util.concurrent.CountDownLatch;

public class Rocket implements Runnable{

    private final CountDownLatch countDownLatch; // ресурс, который мы шарим по разным потокам

    public Rocket(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("Ракета готовится к запуску");
        try {
            countDownLatch.await(); // ожидаем, пока другие операции в других потоках не будут выполнены
            System.out.println("Пуск");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}

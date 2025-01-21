package ru.aston.threads.barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Rocket2 implements Runnable{

    private final CyclicBarrier cyclicBarrier; // ресурс, который мы шарим по разным потокам

    public Rocket2(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println("Ракета готовится к запуску");
        try {
            cyclicBarrier.await(); // ожидаем, пока другие операции в других потоках не будут выполнены
            System.out.println("Пуск");
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }


    }
}

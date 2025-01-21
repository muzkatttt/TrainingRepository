package ru.aston.threads.latch2;

import java.util.concurrent.CountDownLatch;

public class TaskLatch implements Runnable {
    private final CountDownLatch countDownLatch;

    public TaskLatch(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
        // симуляция работы потока
            Thread.sleep((long) (Math.random()*1000));
            System.out.printf("Задача завершена: %s\n", Thread.currentThread().getName());
        } catch (InterruptedException e){
            e.printStackTrace();
        } finally {
            // уменьшаем счетчик
            countDownLatch.countDown();
        }
    }
}

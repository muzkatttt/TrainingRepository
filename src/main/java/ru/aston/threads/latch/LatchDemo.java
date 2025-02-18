package ru.aston.threads.latch;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class  LatchDemo {
    public static void main(String[] args) throws InterruptedException {
//        CountDownLatch countDownLatch = new CountDownLatch(RocketDetail.values().length);
//        ExecutorService executorService = Executors.newFixedThreadPool(3);
//
//        executorService.submit(new Rocket(countDownLatch));
//        Arrays.stream(RocketDetail.values())
//                .map(detail -> new RocketDetailRunnable(detail, countDownLatch))
//                .forEach(executorService::submit);
//        executorService.shutdown();
//        executorService.awaitTermination(1L, TimeUnit.MINUTES);

        CountDownLatch countDownLatch1 = new CountDownLatch(RocketDetail.values().length);
        ExecutorService executorService1 = Executors.newFixedThreadPool(2);
        executorService1.submit(new Rocket(countDownLatch1));
        Arrays.stream(RocketDetail.values())
                .map(detail -> new RocketDetailRunnable(detail, countDownLatch1))
                .forEach(executorService1::submit);
        executorService1.shutdown();
        executorService1.awaitTermination(10L, TimeUnit.MINUTES);
    }
}

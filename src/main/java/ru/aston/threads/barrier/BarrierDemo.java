package ru.aston.threads.barrier;


import java.util.Arrays;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BarrierDemo {
    /*
    Отличие CyclicBarrier от CountDownLatch:
       CyclicBarrier 1 метод await() - все потоки ждут, пока определенное количество
       потоков не вызовет await() (а количество потоков равно количеству, которое передается в cycleBarrior
       c CyclicBarrier лучше использовать Executors.newCachedThreadPool()

       CountDownLatch 2 метода (countDown() и await()) и все потоки жмут await() и ждут,
       пока другие потоки такое же количество раз не вызовут на countDown
       с CountDownLatch можно использовать оба варианта Executors.newFixedThreadPool(3)
     */
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(
                RocketDetail2.values().length,
                () -> System.out.println("Пуск!")); // задача будет выполнена только через 5 деталей
        ExecutorService threadPool = Executors.newCachedThreadPool();


        Arrays.stream(RocketDetail2.values())
                .map(detail -> new RocketDetailRunnable2(detail, cyclicBarrier))
                .forEach(threadPool::submit);   // каждая деталь идет в threadPool

        threadPool.shutdown();
        threadPool.awaitTermination(1L, TimeUnit.MINUTES);    // ожидаем завершения последнего потока

    }
}

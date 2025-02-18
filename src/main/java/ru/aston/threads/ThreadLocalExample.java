package ru.aston.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalExample {
    private static final ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> null);

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

//        Runnable task = () -> {
//            Integer counter = threadLocal.get(); // Получаем текущее значение
//            threadLocal.set(counter == null ? 1 : ++counter); // Устанавливаем новое значение
//            System.out.println(Thread.currentThread().getName() + " → " + threadLocal.get());
//        };
//
//        for (int i = 0; i < 5; i++) {
//            executor.submit(task);
//        }
//
//        executor.shutdown();

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Runnable task1 = () -> {
            Integer counter = threadLocal.get();
            threadLocal.set(counter == null ? 1 : ++counter);
            System.out.println(Thread.currentThread().getName() + " -> " + threadLocal.get());
        };
        executor.submit(task1);
        executor.submit(task1);
        executor.submit(task1);
        executor.submit(task1);
        executor.shutdown();


    }
}

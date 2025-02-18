package ru.aston.threads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SubmitExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Future<?> future = executor.submit(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("Выполняем задачу...");
            }
        });

        System.out.println(future.get()); // Ждем завершения задачи
        System.out.println(future.state());

        executor.shutdown();
    }
}

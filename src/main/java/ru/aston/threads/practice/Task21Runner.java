package ru.aston.threads.practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Task21Runner {
    public static void main(String[] args) {
        Task21 task21 = new Task21();
        Task22 task22 = new Task22();
        task22.start();
        try {
            task22.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

//        Thread executorService = new Thread(task21);
//        executorService.start();

//        ExecutorService service = Executors.newFixedThreadPool(4);
//        service.submit(task21);
//        service.submit(task21);
//        service.submit(task21);
//        service.submit(task21);

        ExecutorService executorService = Executors.newScheduledThreadPool(2);
//        executorService.submit(task21);
//        executorService.submit(task21);
//        executorService.shutdown();

//        executorService.submit(new Task22());
//        executorService.submit(task22);
//        executorService.shutdown();

        Thread newThread = new Thread(new Task22());

        System.out.println("Состояние перед start(): " + newThread.getState()); // NEW

        newThread.start();
        System.out.println("Состояние после start(): " + newThread.getState()); // RUNNABLE

        try {
            Thread.sleep(100); // Ждем завершения потока
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Состояние после завершения: " + newThread.getState()); // TERMINATED

    }
}

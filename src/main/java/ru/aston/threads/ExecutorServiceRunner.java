package ru.aston.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceRunner {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.print("+");;
                }
            }
        };
        //корректно завершить службу исполнения иначе виртуальная машина не закроется
        //executor.shutdown();
        executor.execute(runnable);
        executor.shutdown();
    }
}

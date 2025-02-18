package ru.aston.threads;

import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadsRunner {
    public static void main(String[] args) {
        ObservableSet<Integer> set = new ObservableSet<Integer>(
                new HashSet<Integer>());
        set.addObserver((s, e) -> System.out.println(e));
        for (int i = 0; i < 100; i++)
            set.add(i);


        ExecutorService executor = Executors.newSingleThreadExecutor();
        //запустить задачу на выполнение:
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("задача на выполнение");
            }
        };
        executor.execute(runnable);
        //корректно завершить службу исполнения иначе виртуальная машина не закроется
        executor.shutdown();

    }

}

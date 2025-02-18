package ru.aston.threads.semaphore;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CashboxRunner {

    /*
    Semaphore 2 основных метода:
    acquire() - либо блокирует поток, если нет разрешения (permission),
    либо пропускает поток, если это разрешение есть
    release() - освобождает» выданное ранее разрешение и возвращает его в счётчик
     */
    public static void main(String[] args) throws InterruptedException {
        Semaphore cashboxes = new Semaphore(2, true);
        // 2 -количество касс, true - обслуживать по очереди

        // вариант 1 через ExecutorService
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<Future<?>> futures = Stream.of(
                        new BayerThread(cashboxes),
                        new BayerThread(cashboxes),
                        new BayerThread(cashboxes),
                        new BayerThread(cashboxes),
                        new BayerThread(cashboxes),
                        new BayerThread(cashboxes),
                        new BayerThread(cashboxes),
                        new BayerThread(cashboxes),
                        new BayerThread(cashboxes),
                        new BayerThread(cashboxes),
                        new BayerThread(cashboxes),
                        new BayerThread(cashboxes),
                        new BayerThread(cashboxes),
                        new BayerThread(cashboxes),
                        new BayerThread(cashboxes)
                ).map(executorService::submit)
                .collect(Collectors.toList());

        executorService.shutdown();

        System.out.println(futures.get(0));

        // вариант 2 через Thread
//        List<Thread> threads = Stream.of(
//                        new BayerThread(cashboxes),
//                        new BayerThread(cashboxes),
//                        new BayerThread(cashboxes),
//                        new BayerThread(cashboxes),
//                        new BayerThread(cashboxes),
//                        new BayerThread(cashboxes),
//                        new BayerThread(cashboxes),
//                        new BayerThread(cashboxes),
//                        new BayerThread(cashboxes),
//                        new BayerThread(cashboxes),
//                        new BayerThread(cashboxes),
//                        new BayerThread(cashboxes),
//                        new BayerThread(cashboxes),
//                        new BayerThread(cashboxes)
//                )
//                .map(Thread::new)
//                .peek(Thread::start)
//                .collect(Collectors.toList());
//
//        for (Thread thread : threads) {
//            thread.join();
//        }


    }
}

package threads.pool;

import java.util.concurrent.*;

public class ThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        Executors.newSingleThreadExecutor(); // один поток
//        Executors.newFixedThreadPool(5); // пул потоков 5
//        Executors.newCachedThreadPool(); // безграничное количество потоков
//
//        Executors.newScheduledThreadPool(3); // выполнять задачи с периодичностью либо с задержкой
//        Executors.newWorkStealingPool(); // создает пул на основании ForkJoinPool из оптимального количества потоков

        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(4);
        threadPool.schedule(() -> System.out.println("Ok"), 3L,  TimeUnit.SECONDS);
        //threadPool.scheduleAtFixedRate(
        // () -> System.out.println("Ok"), 3L, 4L,  TimeUnit.SECONDS); // фиксированное время ожидания
        threadPool.shutdown();
        threadPool.awaitTermination(1L, TimeUnit.HOURS);

        test();
    }

    private static void test() throws InterruptedException, ExecutionException {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        Future<Integer> future = threadPool.submit(
                () -> {
                    System.out.println("это Collable");
                    return 1;
                });

        System.out.println("Result: " + future.get());
        threadPool.shutdown(); // ждет выполнения всех потоков
        threadPool.awaitTermination(1L, TimeUnit.HOURS); // время ожидания завершения
        System.out.println("main end");
    }
}

package threads.latch2;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        // CountDownLatch для трех потоков
        CountDownLatch countDownLatch = new CountDownLatch(3);
        // запуск трех потоков
        for (int i = 0; i < 3; i++) {
            new Thread(new TaskLatch(countDownLatch)).start();

        }
        // основной поток ждет пока все потоки завершатся
        countDownLatch.await();
        System.out.println("Все задачи основного потока завершены, продолжение работы потока");
    }
}

package threads.semaphore;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
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

        List<Thread> threads = Stream.of(
                new BayerThread(cashboxes),
                new BayerThread(cashboxes),
                new BayerThread(cashboxes),
                new BayerThread(cashboxes),
                new BayerThread(cashboxes),
                new BayerThread(cashboxes),
                new BayerThread(cashboxes)
        )
                .map(Thread::new)
                .peek(Thread::start)
                .collect(Collectors.toList());

        for (Thread thread : threads) {
            thread.join();
        }
        
        
    }
}

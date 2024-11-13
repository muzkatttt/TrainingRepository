package threads.blockingqueue;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CashboxRunner {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Cashbox> cashboxes = new ArrayBlockingQueue<>(
                2, true, List.of(new Cashbox(), new Cashbox())
                // 2 - размер очереди, true -
        );

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

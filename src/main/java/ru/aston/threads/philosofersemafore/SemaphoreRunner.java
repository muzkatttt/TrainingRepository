package ru.aston.threads.philosofersemafore;

import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SemaphoreRunner {
    public static void main(String[] args) throws InterruptedException {
        Semaphore forks = new Semaphore(5);
        List<Thread> threads = Stream.of(
                new Philosopher(1),
                new Philosopher(2),
                new Philosopher(3),
                new Philosopher(4),
                new Philosopher(5)
        )
                .map(Thread::new)
                .peek(Thread::start)
                .collect(Collectors.toList());
        for (Thread thread : threads) {
            thread.join();
        }
    }
}

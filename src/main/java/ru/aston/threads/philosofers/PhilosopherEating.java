package ru.aston.threads.philosofers;

import java.util.concurrent.locks.ReentrantLock;

public class PhilosopherEating {
    private Thread[] philosophersThread;

    public void action() {
        int philosopherCount = 5;
        ReentrantLock[] forks = new ReentrantLock[philosopherCount];
        for (int i = 0; i < philosopherCount; i++) {
            forks[i] = new ReentrantLock();
        }

        PhilosopherReentrantLock[] philosopherReentrantLocks = new PhilosopherReentrantLock[philosopherCount];
        for (int i = 0; i < philosopherCount; i++) {
            philosopherReentrantLocks[i] = new PhilosopherReentrantLock(forks[i], forks[(i + 1) % philosopherCount], i);
        }
        philosophersThread = new Thread[philosopherCount];
        for (int i = 0; i < philosopherCount; i++) {
            philosophersThread[i] = new Thread(philosopherReentrantLocks[i]);
            philosophersThread[i].start();
        }
    }
    public Thread[] getPhilosophersThread() {
        return philosophersThread;
    }
}


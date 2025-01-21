package ru.aston.threads.philosopherlatch;


import java.util.concurrent.CountDownLatch;

public class PhilosopherEatingLatch {
    private Thread[] philosophersThread;

    public void action() {
        int philosopherCount = 5;
        CountDownLatch[] forks = new CountDownLatch[philosopherCount];
        for (int i = 0; i < philosopherCount; i++) {
            forks[i] = new CountDownLatch(philosopherCount);
        }

        PhilosopherCountDownLatch[] philosopherCountDownLatches = new PhilosopherCountDownLatch[philosopherCount];
        for (int i = 0; i < philosopherCount; i++) {
            philosopherCountDownLatches[i] = new PhilosopherCountDownLatch(forks[i], forks[(i + 1) % philosopherCount], i);
        }
        philosophersThread = new Thread[philosopherCount];
        for (int i = 0; i < philosopherCount; i++) {
            philosophersThread[i] = new Thread(philosopherCountDownLatches[i]);
            philosophersThread[i].start();
        }
    }
    public Thread[] getPhilosophersThread() {
        return philosophersThread;
    }
}
//public class Table extends Thread {
//    private final int PHILOSOPHER_COUNT = 5;
//    private Fork[] forks;
//    private Philosopher[] philosophers;
//    private CountDownLatch cdl;
//
//
//    public Table() {
//        forks = new Fork[PHILOSOPHER_COUNT];
//        philosophers = new Philosopher[PHILOSOPHER_COUNT];
//        cdl = new CountDownLatch(PHILOSOPHER_COUNT);
//        init();
//    }
//
//    @Override
//    public void run() {
//        System.out.println("Заседание макаронных мудрецов объявляется открытым");
//        try {
//            thinkingProcess();
//            cdl.await();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("Все философы накушались");
//    }
//
//    public synchronized boolean tryGetForks(int leftFork, int rightFork) {
//        if (!forks[leftFork].isUsing() && !forks[rightFork].isUsing()) {
//            forks[leftFork].setUsing(true);
//            forks[rightFork].setUsing(true);
//            return true;
//        }
//        return false;
//    }
//
//    public void putForks(int leftFork, int rightFork){
//        forks[leftFork].setUsing(false);
//        forks[rightFork].setUsing(false);
//    }
//
//    private void init() {
//        for (int i = 0; i < PHILOSOPHER_COUNT; i++) {
//            forks[i] = new Fork();
//        }
//
//        for (int i = 0; i < PHILOSOPHER_COUNT; i++) {
//            philosophers[i] = new Philosopher("Philosopher №" + i, this,
//                    i, (i + 1) % PHILOSOPHER_COUNT, cdl);
//        }
//    }
//
//    private void thinkingProcess() {
//        for (Philosopher philosopher : philosophers) {
//            philosopher.start();
//        }
//    }
//}

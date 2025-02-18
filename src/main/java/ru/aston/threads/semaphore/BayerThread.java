package ru.aston.threads.semaphore;


import java.util.concurrent.Semaphore;

public class BayerThread implements Runnable {

    private final Semaphore cashboxes;

    public BayerThread(Semaphore cashboxes) {
        this.cashboxes = cashboxes;
    }

    @Override
    public void run() {
        try {
            cashboxes.acquire(); // acquire() - void захват монитор
            System.out.println(Thread.currentThread().getName()
                    + " обслуживается в какой-то кассе");
            Thread.sleep(4L);
            System.out.println(Thread.currentThread().getName() +
                    " освобождаю кассу ");
            cashboxes.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


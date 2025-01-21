package ru.aston.threads.philosofersemafore;

import java.util.concurrent.Semaphore;

public class Philosopher implements Runnable {
    Semaphore semaphore;

    private int count;

    private int id;

    public Philosopher(int id) {

        this.id = id;
        count = 0;
    }

    public void think() throws InterruptedException {
        System.out.printf("Философ %s думает...\n", id);
        Thread.sleep(1000);
    }

    public void eat() {
        System.out.printf("Философ %s ест\n", id);
    }


    @Override
    public void run() {
//        while (count < 3) {
//            try {
//                semaphore.acquire();
//                eat();
//                semaphore.release();
//                think();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
//try {
//            cashboxes.acquire(); // acquire() - void захват монитор
//            System.out.println(Thread.currentThread().getName()
//                    + " обслуживается в какой-то кассе");
//            Thread.sleep(4L);
//            System.out.println(Thread.currentThread().getName() +
//                    " освобождаю каую-то кассу ");
//            cashboxes.release();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
package ru.aston.threads.philosofers;

import java.util.concurrent.locks.ReentrantLock;

public class PhilosopherReentrantLock implements Runnable {

    // region Поля
    private final ReentrantLock leftFork; // левая вилка через ReentrantLock
    private final ReentrantLock rightFork; // правая вилка через ReentrantLock
    private int id;
    private int count; // количество раз приемов пищи и раздумий

    // endregion

    // region Конструкторы

    public PhilosopherReentrantLock(ReentrantLock leftFork, ReentrantLock rightFork, int id) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.id = id;
        this.count = 0;
    }

    // endregion

    // region Методы

    /**
     * Метод, заставляющий философа думать случайное время
     * @throws InterruptedException
     */
    public void think() throws InterruptedException {
        System.out.println("Философ " + id + " размышляет...");
        Thread.sleep((int) Math.random() * 1000);
    }

    /**
     * Метод, заставляющий философа действовать
     * @param active действие
     * @throws InterruptedException
     */
    public void stepAction() throws InterruptedException {
        System.out.println("Философ " + id + " ест");
        Thread.sleep(((int) (Math.random() * 999)));
        count++;
    }

    /**
     * Метод, запускающий действия философа
     */
    @Override
    public void run() {
        try {
            while (count < 3) {
                // думает
                think();
                leftFork.lock();
                System.out.println("Философ " + id + " взял левую вилку...");
                if (rightFork.tryLock()){
                    try{
                        System.out.println("Философ " + id + " взял правую вилку...");
                        stepAction();
                    } finally {
                        if(rightFork.isHeldByCurrentThread()){
                            rightFork.unlock();
                            System.out.println("Философ " + id + " положил правую вилку...");
                        }
                    }
                } else {
                    leftFork.unlock();
                    Thread.sleep(((int) (Math.random() * 888)));
                }

                if (leftFork.isHeldByCurrentThread()){
                    leftFork.unlock();
                    System.out.println("Философ " + id + " положил левую вилку...");
                }
                // System.out.println(Thread.currentThread().getName() + " поел " + count + " раз(-а)!");
            }
            // endregion
        } catch (InterruptedException e){
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}

//    public void run() {
//        try {
//            while (mealsCount < 3) {
//                think();
//
//                leftFork.lock();
//                System.out.println("Философ " + id + " взял левую вилку");
//
//                if (rightFork.tryLock()) {
//                    try {
//                        System.out.println("Философ " + id + " взял правую вилку");
//                        eat();
//                    } finally {
//                        if (rightFork.isHeldByCurrentThread()) {
//                            rightFork.unlock();
//                            System.out.println("Философ " + id + " положил правую вилку");
//                        }
//                    }
//                } else {
//                    leftFork.unlock();
//                    Thread.sleep(100);
//                }
//
//                if (leftFork.isHeldByCurrentThread()) {
//                    leftFork.unlock();
//                    System.out.println("Философ " + id + " положил левую вилку");
//                }
//            }
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
//    }
//}

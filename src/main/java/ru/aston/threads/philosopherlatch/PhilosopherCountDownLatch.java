package ru.aston.threads.philosopherlatch;

import java.util.concurrent.CountDownLatch;

public class PhilosopherCountDownLatch implements Runnable{
    private final CountDownLatch leftFork;
    private final CountDownLatch rightFork;
    private final int id;
    private int count; // количество раз приемов пищи и раздумий

    public PhilosopherCountDownLatch(CountDownLatch leftFork, CountDownLatch rightFork, int id) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.id = id;
        this.count = 0; // при создании философа количество приемов пищи и раздумий равно нулю
    }

    public void think() throws InterruptedException {
        //System.out.printf("Философ %s размышляет...\n", Thread.currentThread().threadId());
        Thread.sleep(1000);
    }

    public void eat() throws InterruptedException {
        System.out.printf("Философ %s обедает\n", id);
        Thread.sleep(1000);
        count++;
    }

    @Override
    public void run() {
        try{
            while(count<3){
                System.out.println("Философ " + id + " взял левую вилку...\n");
                System.out.println("Философ " + id + " взял правую вилку...\n");
                eat();
                System.out.println("Философ " + id + " положил левую вилку...\n");
                System.out.println("Философ " + id + " положил правую вилку...\n");
                leftFork.countDown();
                rightFork.countDown();
                think();
                System.out.println("Философ " + id + " думает...\n");
            }
        } catch (InterruptedException e){
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
//public class Philosopher extends Thread {
//    private String name;
//    private int leftFork;
//    private int rightFork;
//    private int countEat;
//    private Random random;
//    private CountDownLatch cdl;
//    private Table table;
//
//    public Philosopher(String name, Table table, int leftFork, int rightFork, CountDownLatch cdl) {
//        this.table = table;
//        this.name = name;
//        this.leftFork = leftFork;
//        this.rightFork = rightFork;
//        this.cdl = cdl;
//        countEat = 0;
//        random = new Random();
//    }
//
//    @Override
//    public void run() {
//
//        while (countEat < 3) {
//            try {
//                thinking();
//                eating();
//            } catch (InterruptedException e) {
//                e.fillInStackTrace();
//            }
//        }
//
//        System.out.println(name + " наелся до отвала");
//        cdl.countDown();
//    }
//
//    private void eating() throws InterruptedException {
//        if (table.tryGetForks(leftFork, rightFork)) {
//            System.out.println(name + " уплетает вермишель, используя вилки: " + leftFork
//                    + " и " + rightFork);
//            sleep(random.nextLong(3000, 6000));
//            table.putForks(leftFork, rightFork);
//            System.out.println(name + " покушал, можно и помыслить. " +
//                    "Не забыв при этом вернуть вилки " + leftFork + " и " + rightFork);
//            countEat++;
//        }
//
//    }
//
//    private void thinking() throws InterruptedException {
//        sleep(random.nextLong(100, 2000));
//    }
//}
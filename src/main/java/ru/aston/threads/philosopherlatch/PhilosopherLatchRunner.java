package ru.aston.threads.philosopherlatch;

public class PhilosopherLatchRunner {
    public static void main(String[] args) throws Exception {
        PhilosopherEatingLatch philosopherEatingLatch = new PhilosopherEatingLatch();
            philosopherEatingLatch.action();

    }
}

// Table table = new Table();
//        table.start();
//    }
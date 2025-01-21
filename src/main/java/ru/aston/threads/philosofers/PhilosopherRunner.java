package ru.aston.threads.philosofers;

public class PhilosopherRunner {
    public static void main(String[] args) throws Exception {
        PhilosopherEating philosopherEating = new PhilosopherEating();
        philosopherEating.action();
        for (Thread philosopherThread : philosopherEating.getPhilosophersThread()
        ) {
            try {
                philosopherThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Все философы поели и подумали");
    }
}


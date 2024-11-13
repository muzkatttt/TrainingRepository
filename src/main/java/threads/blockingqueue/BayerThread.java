package threads.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class BayerThread implements Runnable {

    private final BlockingQueue<Cashbox> cashboxes;

    public BayerThread(BlockingQueue<Cashbox> cashboxes) {
        this.cashboxes = cashboxes;
    }

    @Override
    public void run() {
        try {
            Cashbox cashbox = cashboxes.take(); // take пока не будет элемента он ожидает
            System.out.println(Thread.currentThread().getName() + " обслуживается в кассе " + cashbox);
            Thread.sleep(4L);
            System.out.println(Thread.currentThread().getName() + " освобождаю кассу " + cashbox);
            cashboxes.add(cashbox);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


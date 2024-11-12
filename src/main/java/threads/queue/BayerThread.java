package threads.queue;

import java.util.Queue;

public class BayerThread implements Runnable {

    private final Queue<Cashbox> cashboxes;

    public BayerThread(Queue<Cashbox> cashboxes) {
        this.cashboxes = cashboxes;
    }

    @Override
    public void run() {
        try {
            synchronized (cashboxes) {
                while (true) {

                    if (!cashboxes.isEmpty()) {
                        Cashbox cashbox = cashboxes.remove();
                        System.out.println(Thread.currentThread().getName() + " обслуживается в кассе " + cashbox);

                        //Thread.sleep(4L);
                        // ожидание, если захвачен монитор
                        cashboxes.wait(4L);

                        System.out.println(Thread.currentThread().getName() + " освобождаю кассу " + cashbox);
                        cashboxes.add(cashbox);
                        cashboxes.notifyAll(); // notifyAll() - другие потоки все еще ждут, пока поток не выйдет
                        break;
                    } else {
                        System.out.println(Thread.currentThread().getName() + " ожидает свободную кассу");
                        cashboxes.wait(); // поток будет ждать выполнения другим потоком, можно указать время ожидания
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


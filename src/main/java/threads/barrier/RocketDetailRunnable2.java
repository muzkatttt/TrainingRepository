package threads.barrier;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


public class RocketDetailRunnable2 implements Runnable{
    private final RocketDetail2 rocketDetail;
    private final CyclicBarrier cyclicBarrier;

    public RocketDetailRunnable2(RocketDetail2 rocketDetail, CyclicBarrier cyclicBarrier) {
        this.rocketDetail = rocketDetail;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println("Готовится деталь: " + rocketDetail);
        try {
            Thread.sleep(1000L);
            System.out.println("Деталь готова и ожидает: " + rocketDetail);
            cyclicBarrier.await(); // все потоки, которые вызвали await - ожидают до тех пор,
            // пока определенное количесто потоков не вызовут этот метод - 5 деталей
            // метод await() не освобождает поток
            System.out.println("Деталь использована: " + rocketDetail);
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

    }
}

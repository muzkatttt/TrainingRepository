package ru.aston.threads.task;

import java.util.Queue;

public class ConsumerThread implements Runnable {

    private final Queue<Integer> list;

    public ConsumerThread(Queue<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        synchronized (list) {
            while (true) {
                if (!list.isEmpty()) {
                    Integer removedValue = list.remove();
                    System.out.println("consumer get value: " + removedValue + ".Size: " + list.size());
                } else {
                    System.out.println("Consumer is waitting, List is empty");
                }
                list.notifyAll();
                try {
                    int random = RandomUtil.getRandom(40);
                    System.out.println("consumer wait: " + random);
//                    Thread.sleep(RandomUtil.getRandom());
                    list.wait(random);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

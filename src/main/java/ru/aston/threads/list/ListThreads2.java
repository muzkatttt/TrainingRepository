package ru.aston.threads.list;

import java.util.List;

public class ListThreads2 implements Runnable{
    private final List<Integer> list;

    public ListThreads2(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 400; i++) {
            synchronized (list){
                list.add(i);
            }
        }
    }
}

package ru.aston.threads.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private int money;
    private int id;
    private static int generator = 1;
    private final Lock lock = new ReentrantLock(); // реализация метода Lock

    public Account(int money) {
        this.money = money;
        this.id = generator++;
    }

    public void add(int money){
        this.money += money;
    }

    public boolean takeOff(int money){
        if(this.money >= money){
            this.money -= money;
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", money=" + money +
                '}';
    }


    public Lock getLock() {
        return lock;
    }
}

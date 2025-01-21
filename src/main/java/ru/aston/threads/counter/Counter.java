package ru.aston.threads.counter;

/**
 * 1. Создать класс Counter с одним полем:
 * private int count;
 * добавить методы:
 * getCount() - для получения поля count
 * increment() - для увеличения значения поля на единицу
 * decrement() - для уменьшения значения поля на единицу
 */
public class Counter {
    private static String description;
    private int count;

    // synchronized на уровне метода определяет,
    // что только один поток у одного объекта  может получить доступ к методу,
    // ни один из потоков не может получить доступ,
    // пока этот поток его не разблокирует
//    public synchronized void increment(){
//        count++;
//    }

    public static void init(){
        Class<Counter> counterClass = Counter.class;
        //synchronized (Counter.class) { // можно обойтись без инициализации counterClass
        synchronized (counterClass) { // аналогия захвата монитора
            if (description == null) {
                description = "Test description";
            }
        }
    }
    // synchronized на уровне блока
    public void increment() {
        synchronized (this) { // (this.getClass())
            count++;
        }
    }

    // synchronized самодокументированный если в методе
    public synchronized void decrement() {
        count--;
    }

    public int getCount() {
        return count;
    }
}

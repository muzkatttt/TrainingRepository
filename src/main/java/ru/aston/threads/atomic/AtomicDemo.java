package ru.aston.threads.atomic;

import java.util.concurrent.atomic.AtomicInteger;


public class AtomicDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        int value = atomicInteger.incrementAndGet();
        System.out.println(value);

        int newValue = atomicInteger.addAndGet(20);
        System.out.println(newValue);
    }
}

// не использовать!!!! только для примера
//        Unsafe unsafe = Unsafe.getUnsafe();
//        unsafe.addressSize();
package threads.atomic;

import java.util.concurrent.atomic.AtomicInteger;


public class AtomicDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        int value = atomicInteger.incrementAndGet();
        System.out.println(value);

        // не использовать!!!! только для примера
//        Unsafe unsafe = Unsafe.getUnsafe();
//        unsafe.addressSize();

        int newValue = atomicInteger.addAndGet(20);
        System.out.println(newValue);
    }
}

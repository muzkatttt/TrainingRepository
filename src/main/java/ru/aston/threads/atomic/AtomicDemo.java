package ru.aston.threads.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.LongBinaryOperator;
import java.util.stream.IntStream;


public class AtomicDemo {
    public static void main(String[] args) throws InterruptedException {
//        AtomicInteger atomicInteger = new AtomicInteger();
//        int value = atomicInteger.incrementAndGet();
//        System.out.println(value);
//
//        int newValue = atomicInteger.addAndGet(20);
//        System.out.println(newValue);

    //Метод updateAndGet() принимает в качестве аргумента лямбда-выражение
        // и выполняет над числом заданные арифметические операции:
        AtomicInteger atomicInt = new AtomicInteger(0);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        IntStream.range(0, 2000)
                .forEach(i -> {
                    Runnable task = () ->
                            atomicInt.updateAndGet(n -> n+2);
                    executor.submit(task);
                });

        executor.shutdown();
        executor.awaitTermination(100L, TimeUnit.SECONDS);

        System.out.println(atomicInt.get());


    //Метод accumulateAndGet() принимает лямбда-выражения типа IntBinaryOperator.
        // можно использовать его, чтобы просуммировать все числа от нуля до тысячи:
        AtomicInteger atomicInt2 = new AtomicInteger(0);

        ExecutorService executor2 = Executors.newFixedThreadPool(2);

        IntStream.range(0, 2000)
                .forEach(i -> {
                    Runnable task = () ->
                            atomicInt2.accumulateAndGet(i, Integer::sum);
                    executor2.submit(task);
                });

        executor2.shutdown();
        executor2.awaitTermination(100L, TimeUnit.SECONDS);

        System.out.println(atomicInt2.get());


        // Класс LongAdder в качестве альтернативы AtomicLong для последовательного сложения чисел:
        ExecutorService executor3 = Executors.newFixedThreadPool(2);
        LongAdder adder = new LongAdder();

        IntStream.range(0, 1000)
                .forEach(i -> executor3.submit(adder::increment));

        executor3.shutdown();
        executor3.awaitTermination(100L, TimeUnit.SECONDS);
        System.out.println(adder.sumThenReset());

        //Класс LongAccumulator несколько расширяет возможности LongAdder.
        // Вместо простого сложения он обрабатывает входящие значения
        // с помощью лямбды типа LongBinaryOperator, которая передаётся при инициализации:

        LongBinaryOperator op = (x, y) -> x + 2 * y;
        LongAccumulator accumulator = new LongAccumulator(op, 1L);

        ExecutorService executor4 = Executors.newFixedThreadPool(2);

        //при каждом вызове accumulate() значение аккумулятора увеличивается в два раза,
        // и лишь затем суммируется с i.
        // LongAccumulator хранит весь набор переданных значений в памяти:
        IntStream.range(0, 9)
                .forEach(i -> executor4.submit(() -> accumulator.accumulate(i)));

        executor4.shutdown();
        executor4.awaitTermination(100L, TimeUnit.SECONDS);
        System.out.println(accumulator.getThenReset());
    }
}

// не использовать!!!! только для примера
//        Unsafe unsafe = Unsafe.getUnsafe();
//        unsafe.addressSize();
package ru.aston.threads;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;

public class ConcurrentHashMapForEachSearchReduceRunner {
    public static void main(String[] args) {
        //ForkJoinPool.commonPool() в Java 8.
        // Этот пул использует свои настройки для количества потоков, основанные на количестве ядер:
        System.out.println(ForkJoinPool.getCommonPoolParallelism());

        //методы forEach(), search() and reduce().
        // У каждого из них есть первый аргумент, который называется parallelismThreshold,
        // который определяет минимальное количество элементов в коллекции,
        // при котором операция будет выполняться в нескольких потоках:


        ConcurrentHashMap map = new ConcurrentHashMap<>();
        map.put("foo", "bar");
        map.put("han", "solo");
        map.put("r2", "d2");
        map.put("c3", "p0");
        map.put("ref4", "peek");
        map.put("some", "poll0");
        map.put("pou1", "left");
        map.put("const5", "right");
        map.put("any", "more");


        //forEach() работает так же, как и в ConcurrentMap:
        map.forEach(1, (key, value) ->
                System.out.printf("key: %s; value: %s; thread: %s\n",
                        key, value, Thread.currentThread().getName()));

        //search() принимает лямбда-выражение типа BiFunction,
        // в которую передаются все пары ключ-значение по очереди.
        // Функция должна возвращать null, если необходимое вхождение найдено.
        // В случае, если функция вернёт не null, дальнейший поиск будет остановлен:

        String result = String.valueOf(map.search(1, (key, value) -> {
            System.out.println(Thread.currentThread().getName());
            if ("const5".equals(key)) {
                return value;
            }
            return null;
        }));
        System.out.println("Result: " + result);


        //поиск только по значениям:
        // в строке 24 пара ключ-значение map.put("some", "poll0");
        String result2 = String.valueOf(map.searchValues(1, value5 -> {
            System.out.println(Thread.currentThread().getName());
            if (value5.toString().length()> 3) {
                return value5;
            }
            return null;
        }));

        System.out.println("Result: " + result2); // вернет в консоль -> poll0

        System.out.println();

        //Метод reduce() принимает две лямбды типа BiFunction.
        // Первая функция преобразовывает пару ключ/значение в один объект (любого типа).
        // Вторая функция совмещает все полученные значения в единый результат,
        // игнорируя любые возможные null-значения:

        String result123 = String.valueOf(map.reduce(1,
                (key, value) -> {
                    System.out.println("Transform: " + Thread.currentThread().getName());
                    return key + "=" + value;
                },
                (s1, s2) -> {
                    System.out.println("Reduce: " + Thread.currentThread().getName());
                    return s1 + ", " + s2;
                }));

        System.out.println("Result: " + result123);



    }
}

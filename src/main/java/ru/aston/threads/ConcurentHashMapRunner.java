package ru.aston.threads;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ForkJoinPool;

public class ConcurentHashMapRunner {
    public static void main(String[] args) {
        ConcurrentMap map = new ConcurrentHashMap<>();
        map.put("key1", "value1");
        map.put("key2", "val");
        map.put("key3", "valval");
        map.put("key4", "ok ok");

        //Метод forEach() принимает лямбду типа BiConsumer.
        // Этой лямбде будут передаваться в качестве аргументов все ключи и значения таблицы по очереди.
        // Этот метод может использоваться как замена for-each циклам с итерацией по всем Entry.
        // Итерация выполняется последовательно, в одном потоке
        map.forEach((key, value) -> System.out.printf("%s = %s\n", key, value));

        //putIfAbsent() помещает в таблицу значение, только если по данному ключу ещё нет другого значения:
        String value = (String) map.putIfAbsent("key4", "put new value");
        System.out.println(value);


        //getOrDefault() работает так же, как и обычный get(),
        // но при отсутствии значения по данному ключу он вернёт значение по-умолчанию,
        // передаваемое вторым аргументом:
        String value2 = map.getOrDefault("key5", "there").toString();
        System.out.println(value2);



        //replaceAll() принимает в качестве аргумента лямбда-выражение типа BiFunction.
        // Этой лямбде по очереди передаются все комбинации ключ-значения из карты,
        // а результат, который она возвращает, записывается соответствующему ключу в качестве значения:
        map.replaceAll((key3, value3) -> "key2".equals(key3) ? "new value" : value3);
        System.out.println(map.containsKey("key2"));
        System.out.println(map.get("key2"));

        //изменить только один ключ, это позволяет сделать метод compute():
        map.compute("key3", (key4, value4) -> value4 + " + added some value");
        System.out.println(map.get("key3"));


        //Кроме обычного compute(), существуют так же методы computeIfAbsent() и computeIfPresent().
        // Они изменяют значение только если значение по данному ключу отсутствует (или присутствует, соответственно).


        //метод merge() для объединения существующего ключа с новым значением.
        // В качестве аргумента он принимает ключ, новое значение и лямбду, которая определяет,
        // как новое значение должно быть объединено со старым:
        map.merge("key4", "ho ho ho", (oldVal, newVal) -> newVal + " was " + oldVal);
        System.out.println(map.get("key4"));

        System.out.println(map.entrySet());



    }
}

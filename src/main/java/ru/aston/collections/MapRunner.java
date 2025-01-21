package ru.aston.collections;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class MapRunner {
    public static void main(String[] args) {

        ConcurrentMap<Integer,String> hashMap = new ConcurrentHashMap<>();
        hashMap.put(1,"value");

        Map<String, Integer> phoneBook = new HashMap<>();

        // добавить элементы
        phoneBook.put("Ivanov", 911_233_22);
        phoneBook.put("Sidorov", 923_233_22);
        phoneBook.put("Petrov", 911_233_77);
        phoneBook.put("Smirnov", 931_777_22);
        phoneBook.put("Mishkin", 304_435_934);
        System.out.println(phoneBook);

        // получить элемент по ключу
        System.out.println(phoneBook.get("Ivanov"));

        System.out.println(phoneBook.size());

        // удалить элемент
//        System.out.println(phoneBook.remove("Petrov"));
//        System.out.println(phoneBook.remove("Smirnov", 931777));
//        System.out.println(phoneBook);

        // заменить элемент
        phoneBook.put("Ivanov", 777777777);
        System.out.println(phoneBook);

        // содержится ли ключ или значение
        System.out.println(phoneBook.containsKey("Smirnov"));
        System.out.println(phoneBook.containsValue(93));

        // очистить коллекцию
//        phoneBook.clear();

        Set<String> strings = phoneBook.keySet();
        Collection<Integer> values = phoneBook.values();

        Set<String> setOne = Set.of("A", "B", "C");
        System.out.println(setOne);

        ArrayList<String> strings1 = new ArrayList<>(new HashSet<>(Set.of("A", "B", "C")));
        System.out.println(strings1);

        for (String str : strings) {
            System.out.println(str);
        }

        for (Integer integer : values) {
            System.out.println(integer);
        }

        Set<Map.Entry<String, Integer>> entries = phoneBook.entrySet();

        for (Map.Entry<String, Integer> entry : entries){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}

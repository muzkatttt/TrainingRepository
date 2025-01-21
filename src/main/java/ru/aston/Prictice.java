package ru.aston;

import java.util.HashSet;
import java.util.Set;

public class Prictice {
    public static void main(String[] args) {
        // 4 способа содания строки с помощью StringBuffer
        // метод replace():
        StringBuffer str = new StringBuffer();
        str.append("Hello");
        str.replace(5, 6, "World");
        String result = str.toString();
        System.out.println(result);

        // метод append() - просто добавить
        StringBuffer str3 = new StringBuffer();
        str3.append("Hello");
        str3.append(" World");
        String result3 = str3.toString();

        // метод insert() - добавить на определенную позицию
        StringBuffer str1 = new StringBuffer();
        str1.insert(0, "Hello");
        str1.insert(5, "World");
        String result1 = str1.toString();
        System.out.println(result1);

        //Используя конструктор с параметром типа String:
        String initialString = "Hello";
        StringBuffer str4 = new StringBuffer(initialString);
        String result4 = str4.toString();
        System.out.println(result4);

        Set<Integer> integerSet = new HashSet<>(10);
        integerSet.add(1);
        integerSet.add(2);
        integerSet.add(4);
        integerSet.stream().map(x -> x * x).forEach(System.out::println);
    }
}

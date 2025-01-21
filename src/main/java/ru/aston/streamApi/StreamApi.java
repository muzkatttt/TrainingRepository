package ru.aston.streamApi;

import java.util.List;
import java.util.function.IntUnaryOperator;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class StreamApi {
    public static void main(String[] args) {
//        Function<Double, Long> function = d -> Math.round(d);
//        System.out.println(function.apply(7.777));
//
//        Function<String, Integer> valueConverter = x -> Integer.valueOf(x);
//        System.out.println(valueConverter.apply("6789"));
//
//        List<String> names = Arrays.asList("Smith", "Gourav", "John", "Catania");
//        Function<String, Integer> nameMappingFunction = String::length;
//        List<Integer> nameLength = names.stream()
//                .map(nameMappingFunction)
//                .collect(Collectors.toList());
//        System.out.println(nameLength);
//
//        Map<Integer, String> mymap = new HashMap<>();
//        mymap.put(12, "09878909");
//        mymap.size();
//        System.out.println(mymap.size());

        //maskify("9999 9999 9999 8888");

        List<String> list = List.of("1", "88", "2", "33", "99", "09", "78", "65", "54");
        streamStringValue(list);
    }

    /*
    для работы с примитивами IntStream(), DoubleStream(), LongStream()
     */
    public static String maskify(String str) {
//        //написать функцию, которая заменяет все символы, кроме последних четырех, на "#".
//        //throw new UnsupportedOperationException("Unip");
        //return str.replaceAll(".(?=.{4})", "#");
        //return str.length() < 5 ? str : "#".repeat(str.length() - 4) + str.substring(str.length() - 4);

        if (str.length() <= 4) {
            return str;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length() - 4; i++) {
            result.append("#");
        }
        result.append(str.substring(str.length() - 4));

        return result.toString();
    }

    public static void streamStringValue(List<String> list){
        list.stream().map(str -> str + str)
                .map(Integer::valueOf) // значения Integer
                .filter(value -> value % 2 == 0)
                .sorted() // отсортировать - здесь через компаратор
                .skip(1) // пропустить
                .forEach(System.out::println);

        // то же самое, но без стримов
        for (String str : list){
            String value = str + str;
            Integer intValue = Integer.valueOf(value);
            if(intValue % 2 == 0){
                System.out.println(intValue);
            }
        }

        List<String> newList = List.of("1", "8", "2", "3", "9", "9", "7", "6", "5");

                newList.stream()
                        .map(str -> str + str)
                .map(Integer::valueOf) //
                        .mapToInt(Integer::intValue)// значения Integer
        .summaryStatistics();
        System.out.println(newList);
        // стрим для работы с int
        list.stream().map(str -> str + str)
                .map(Integer::valueOf) // значения Integer
                .mapToInt(value -> value.intValue())
                .peek(System.out::println) // peek() не останавливает поток
                .forEach(System.out::println);

        IntStream.of(1, 2, 4, 6, 7, 8, 8, 8, 8, 9)
                //.peek(System.out::println)
                .filter(x -> x % 2 == 0)
                .forEach(System.out::println);

        IntStream.range(5, 10)
                        .forEach(System.out::println);

        IntStream.iterate(3, new IntUnaryOperator() { // анонимный класс
            @Override
            public int applyAsInt(int operand) { // вместо new IntUnaryOperator() можно написать через лямбду
                // x -> x + 3
                return operand +3;
            }
        })
                .skip(2)
                .filter(x -> x % 2 ==0) // выведет значения от 12 до 66 с шагом 6, первые два пропустит
                .limit(10) // выведет 10 значений
                .forEach(System.out::println);

        DoubleStream.of(19.0, 20.0, 220000.0)
                //.findAny()
                //.stream()
                .skip(2)
                .forEach(System.out::println);

        LongStream.of(12234543L, 88888L, 99999L)
                .average()
                .stream()
                .forEach(System.out::println);
    }
}

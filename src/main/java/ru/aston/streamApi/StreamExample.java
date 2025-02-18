package ru.aston.streamApi;

import java.util.*;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        List<Dish> dishes = Arrays.asList(
                new Dish("french fries", true, 550, Dish.Type.OTHER),
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 350, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 500, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 400, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH)
        );

//        dishes.stream().sorted(Comparator.comparing(Dish::getName))
//                .collect(Collectors.toList())
//                .forEach(System.out::println);
// метод экземпляра через класс ------>  Dish::isVegetarian
        dishes.stream().sorted(Comparator.comparing(Dish::isVegetarian))
                .collect(Collectors.toList())
                .forEach(System.out::println);
        System.out.println();

        dishes.stream().sorted(Comparator.comparing(Dish::getName)
                        .thenComparing(Dish::getCalories).
                        thenComparing(Dish::getType))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println();
        dishes.stream().sorted(Comparator.comparing(Dish::isVegetarian)
                        .thenComparing(Dish::getCalories).thenComparing(Dish::getName))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("\nметод экземпляра --> Dish::getName");
        dishes.stream().sorted(Comparator.comparing(Dish::getName))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("\nнахождение среднего значения калорий");
        double avgCalories = dishes.stream()
                .mapToInt(Dish::getCalories)
                .summaryStatistics()
                .getAverage();
        System.out.println(Math.round(avgCalories));

        System.out.println("\nнахождение суммы калорий во всех блюдах");
        double sumCalories = dishes.stream()
                .mapToInt(Dish::getCalories)
                .summaryStatistics().getSum();

        System.out.println(Math.round(sumCalories));

        System.out.println("\nнахождение блюда на букву p:");

        boolean isStartWithP = dishes.stream()
                .anyMatch(dish -> dish.getName().charAt(0) == 'p');
        System.out.println(isStartWithP);

        System.out.println("\nЛямбда-ссылка на конструктор ---> LinkedList::new \nПреобразование одной коллекцию в другую");
        List<Dish> newC = dishes.stream().collect(Collectors.toCollection(LinkedList::new));
        System.out.println(newC);

        long countDifferenceDishes = dishes.stream()
                .map(Dish::getName)
                .distinct()
                .count();

        System.out.println(countDifferenceDishes);

        System.out.println("\nразличия flatMap() и ,map()");
        List<String> words = List.of("я разделяю", " все буквы для удобного чтения");
        List<String> letters = words.stream()
                .flatMap(word -> Arrays.stream(word.split("")))
                .collect(Collectors.toList());
        System.out.println(letters);


//    }

//    public static Set<String> getKidNames(List<Dish> dish) {
        // Set<String> kids = new HashSet<>();
        // for (Person person : people) {
        // 	if (person.getAge() < 18) {
        // 		kids.add(person.getName());
        // 	}
        // }
        // return kids;
        Set<String> str = dishes.stream()
                .filter(person -> person.getName().charAt(0) == 'f')
                .map(Dish::getName).collect(Collectors.toSet());

        System.out.println(str);

        long countDishes = dishes.stream().count();
        System.out.println(countDishes);



        List<String> someString = List.of("ca t", "d og", " mouse"," стро ка 3");
        List<String> stringFlatMap = someString.stream()
                .flatMap(word -> Arrays.stream(word.split(" ")))
                .collect(Collectors.toList());
        System.out.println(stringFlatMap);

        List<String> anotherStr = Arrays.asList(",ewf w", "sfs fs", "dsgv sd fg");
        List<String> strFltMp = anotherStr.stream()
                .flatMap(word -> Arrays.stream(word.split(" ")))
                .collect(Collectors.toList());
        System.out.println(strFltMp);

        List<String> som = Arrays.asList("первый день на работе это понедельник", "а второй день на работе это вторник");
        List<String> sstream = som.stream()
                .flatMap(a -> Arrays.stream(a.split(" ")))
                .collect(Collectors.toList());
        System.out.println(sstream);

        List<String> intNum = Arrays.asList("1, 3, 5, 6, 7, 8", "9, 90, 2, 1, 0, 89");
        List<String> intAnothers = intNum.stream()
                .flatMap(word -> Arrays.stream(word.split(" ")))
                .collect(Collectors.toList());
        System.out.println(intAnothers);

        List<Integer> ints = Arrays.asList(1,2,3,4,5);
        List<Integer> int2 = ints.stream().map(a -> a*a*a).collect(Collectors.toList());
        System.out.println(int2);


        List<String> doum = intNum.stream().flatMap(num -> Arrays.stream(num.split(", "))).collect(Collectors.toList());
        System.out.println(doum);

        List<String> javaKat = intNum.stream().flatMap(num-> Arrays.stream(num.split(", "))).collect(Collectors.toCollection(LinkedList::new));
        System.out.println(javaKat);
    }
}


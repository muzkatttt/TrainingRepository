package ru.aston.streamApi;

import ru.aston.hwLesson3.entities.heroes.Archer;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapReduce{
    public static void main(String[] args) {
        Stream.of(
                new Archer("Archer0", 50),
                new Archer("Archer1", 100),
                new Archer("Archer2", 150),
                new Archer("Archer3", 50),
                new Archer("Archer4", 60),
                new Archer("Archer5", 80),
                new Archer("Archer6", 90),
                new Archer("Archer7", 40),
                new Archer("Archer8", 200)
        )
                //.parallel() // при большом потоке позволяет распределить и выполнить вычисление быстрее
                .sequential() // обработка в одном потоке
                .map(Archer::getHealth)
                .filter(health -> health > 50)
                .sorted()
                //.reduce((health1, health2) -> Math.max(health1, health2))// reduce(Math::max)
                .reduce(Integer::sum) // сложить все значения здоровья у всех лучников
                //.forEach(System.out::println);
                .ifPresent(System.out::println); // заменяет forEach - для одного значения

        final IntSummaryStatistics intSummaryStatistics = Stream.of(
                        new Archer("Archer0", 50),
                        new Archer("Archer1", 100),
                        new Archer("Archer2", 150),
                        new Archer("Archer3", 50),
                        new Archer("Archer4", 60),
                        new Archer("Archer5", 80),
                        new Archer("Archer6", 90),
                        new Archer("Archer7", 40),
                        new Archer("Archer8", 200)
                )
                .map(Archer::getHealth)
                .mapToInt(Integer::shortValue)
                .summaryStatistics();
        System.out.println(intSummaryStatistics);

        final List<Archer> archerName = Stream.of(
                new Archer("Archer0", 50),
                new Archer("Archer1", 100),
                new Archer("Archer2", 150),
                new Archer("Archer3", 50),
                new Archer("Archer4", 60),
                new Archer("Archer5", 80),
                new Archer("Archer6", 90),
                new Archer("Archer7", 40),
                new Archer("Archer8", 200)
        ).sorted(Comparator.comparing(Archer::getHealth)).collect(Collectors.toList());
        System.out.println(archerName);

        int [] array = new int[10];
        int i = 0;
        for(; i <10; i++){
            if (array[i] % 2 == 0) continue;
            System.out.println(i);
        }
    }

}

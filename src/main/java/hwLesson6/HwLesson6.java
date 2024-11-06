package hwLesson6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HwLesson6 {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
//        task1(transactions);
//        task2(transactions);
//        task3(transactions);
//        task4(transactions);
//        task5(transactions);
//        task6(transactions);
        task7(transactions);
        task8(transactions);
    }

    //1. Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей к большей).
    public static void task1(List<Transaction> transactions) {
        transactions.stream()
                .filter((x) -> x.getYear() < 2012)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .collect(Collectors.toList())
                .forEach(System.out::println);
//        for (Transaction t : transactions){
//            System.out.println(t);
    }

    //2. Вывести список неповторяющихся городов, в которых работают трейдеры.
    public static void task2(List<Transaction> transactions) {
        transactions.stream()
                .map(x -> x.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);
    }

    //3. Найти всех трейдеров из Кембриджа и отсортировать их по именам.
    public static void task3(List<Transaction> transactions){
        transactions.stream()
                .filter(trader-> trader.getTrader().getCity().equals("Cambridge"))
                .sorted((trader1, trader2) -> trader1.getTrader().getName().compareTo(trader2.getTrader().getName()))
                .forEach(System.out::println);
    }

    //4. Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном порядке
    public static void task4(List<Transaction>transactions){
        transactions.stream()
                .map(trader -> trader.getTrader().getName())
                .sorted((trader1, trader2) -> trader1.compareTo(trader2))
                .distinct()
                .forEach(System.out::println);
    }

    // 5. Выяснить, существует ли хоть один трейдер из Милана
    public static void task5(List<Transaction>transactions) {
        transactions.stream()
                .filter(trader -> trader.getTrader().getCity().equals("Milan"))
                .findFirst()
                .ifPresent(System.out::println);
    }

    // 6. Вывести суммы всех транзакций трейдеров из Кембриджа
    public static void task6(List<Transaction>transactions){
        transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::sum)
                .ifPresent(System.out::println);
    }

    //7. Какова максимальная сумма среди всех транзакций?
    public static void task7(List<Transaction>transactions){
        transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max)
                .ifPresent(System.out::println);
    }

    // 8. Найти транзакцию с минимальной суммой
    public static void task8(List<Transaction>transactions){
        transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::min)
                .ifPresent(System.out::println);
    }

}
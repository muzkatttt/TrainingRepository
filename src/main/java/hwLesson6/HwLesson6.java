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
        task1(transactions);
    }

    //Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей к большей).
    public static void task1(List<Transaction> transactions) {
        transactions.stream()
                .filter((x) -> x.getYear() <2012)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .collect(Collectors.toList())
                .forEach(System.out::println);
//        for (Transaction t : transactions){
//            System.out.println(t);
//        }

    }
}
//sorted(Comparator.comparingInt(Transaction::getAmount))
//                .collect(Collectors.toList());
//
//        transactions2011.forEach(System.out::println);

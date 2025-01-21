package ru.aston.hw1Intensive;

public class Main {
    public static void main(String[] args) {
        KateRodionova<Integer> kateRodionova = new KateRodionova<>();

        kateRodionova.add(1);
        kateRodionova.add(2);
        kateRodionova.add(3);
        kateRodionova.add(4);
        kateRodionova.add(5);
        kateRodionova.add(6);
        kateRodionova.add(7);
        kateRodionova.add(8);

        kateRodionova.add(1, 6);

        final int size = kateRodionova.size();
        System.out.println(size);

    }
}

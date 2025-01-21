package ru.aston.hwLesson5;

import java.util.ArrayList;

public class HwLes5 {
    public static void main(String[] args) throws NoSuchMethodException {
//        LinkedListCatsCollection<String> cats = new LinkedListCatsCollection<>(5);
//        cats.add("cat Karamel`ka");
//        cats.add("cat Barny");
//        cats.add("cat Kotofey");
//        cats.add("cat Pel`meshka");
//        cats.add("cat Rysya");
//
//        System.out.println(cats.get(3));
//        System.out.println(cats.showAll());
//
//        cats.remove("cat Barny");
//        cats.showAll();


        MyCollection<String> list = new MyCollection<>(5);
        list.add("Karamel`ka");
        list.add("Barny");
        list.add("Kotofey");
        list.add("Pel`meshka");
        list.add("Rysya");

        System.out.printf("Список:%s\n", list);
        System.out.println(list.get(0));
        list.remove(0);
        System.out.println(list);

        MyCollection<String> copyList = new MyCollection<>(2);
        copyList.add("Cat3");
        copyList.add("Another");
        copyList.addAll(list);
        ArrayList<String> array = new ArrayList<>();
        array.add("Busya");
        array.add("Pushok");
        array.add("Cat4");

        System.out.println(array);
        copyList.showAll();

        MyInterface.bubbleSort(copyList);
        copyList.showAll();

        MyCollection<Integer> intList = new MyCollection<>(5);
        intList.add(1);
        intList.add(6);
        intList.add(32);
        intList.add(4);
        intList.add(7);
        intList.showAll();
        intList.sort();
        intList.showAll();
        intList.showAll();
        MyInterface.bubbleSort(intList);
        intList.showAll();

    }
}

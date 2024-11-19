package collections;

import java.util.*;

public class ListRunner {
    public static void main(String[] args) {
        List<String> friends = new ArrayList<>();

        List<String> list = List.of("Str", "Str2", "Str3");
        //list.add(" ");

        // добавить элемент
        friends.add("");
        friends.add("Sidorov");
        friends.add("Apina");
        friends.add("Sutkin");
        friends.add("Frodo");

        Iterator<String> iterator = friends.iterator();

        while(iterator.hasNext()) {
            String next = iterator.next();
            friends.remove(next);
        }

        System.out.println(friends.size());

        // вставка элемента
        friends.add(5, "Gendalf");

        // получение элемента из коллекции
        System.out.println("Получение элемента " + friends.get(1));

        // коструктор с добавлением элементов из другой коллекции
        ArrayList<String> friendsSecond = new ArrayList<>(friends);

        System.out.println(friends);
        System.out.println(friends.size());

        // удалить элемент
        List<Integer> num = new ArrayList<>();

        System.out.println(friends.remove(0));
        System.out.println(friends.remove("Sutkin"));
        System.out.println(friends);

        // замена элемента по индексу
        friends.set(3, "Sokolov");
        System.out.println(friends);

        // очистка списка
        friends.clear();
        System.out.println(friends);

        // добавление нескольких элементов
        friends.addAll(friendsSecond);
        System.out.println(friends);

        // содержится ли элемент
        System.out.println(friends.contains("Ivanov"));

        // получить индекс элемента
        System.out.println(friends.indexOf("Frodo"));
        System.out.println(friends.get(1));

        for (String str : friends) {
            System.out.println(str.length());
        }

        List<String> string1 = List.of("String", "String2", "Strint3");

        List<String> list2 = Arrays.asList("String", "String2");

        List<String> someList3 = new LinkedList<>(string1);

        someList3.get(3);

        int[] numbers = {2, 34, 434};
        StringBuffer str = new StringBuffer();
        str.append("Hello");
        str.replace(5, 10, "World");
        String result = str.toString();
    }
}

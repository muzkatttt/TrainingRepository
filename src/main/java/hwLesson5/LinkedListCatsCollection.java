package hwLesson5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class LinkedListCatsCollection<E> {
    private List<E> listCats;

    public LinkedListCatsCollection(Collection<E> collection) {
        listCats = new ArrayList<>(collection.size());
    }

    public static <E extends String> void sorted() {


    }

    public List<E> add(E element) {
        listCats.add(element);
        return listCats;
    }


    public E get(int number) {
        return listCats.get(number);
    }

    public void remove(E element) {
        listCats.remove(element);
    }

    public void addAll(Collection<E> list) {
        List<E> list2 = new LinkedList<>(list);
        for (E element : list2) {
            add(element);
            System.out.printf("Добавлен %s элемент", element);
        }
    }

    public void addAll2(List<E> list) {
        list.addAll(list);
    }

    public List<E> showAll() {
        List<E> newList = new LinkedList<>();
        newList.addAll(listCats);
        return newList;
    }
}

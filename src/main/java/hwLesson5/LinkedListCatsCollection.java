package hwLesson5;

import java.util.*;

public class LinkedListCatsCollection<T> implements MyInterface<T>, Sort<T> {
    //private List<T> listCats;
    private T[] array;
    private int size = 0;


//    public LinkedListCatsCollection(Collection<T> collection) {
//        listCats = new ArrayList<>(collection.size());
//    }

    public LinkedListCatsCollection(int length) {
        array = (T[]) new Object[length];
    }

    public LinkedListCatsCollection(Collection<? extends T> collection) {
        array = (T[]) new Object[size];
        size = collection.size();
        int i = 0;
        for (T elem : collection) {
            i++;
            array[i] = elem;
        }
    }

    public void add(T element) {
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[size] = element;
        size++;
    }


    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Выход за пределы массива");
        }
        return array[index];
    }

    public void remove(T element) {
        for (int i = 0; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    public void addAll(Collection<T> list) {
        List<T> list2 = new LinkedList<>(list);
        for (T element : list2) {
            add(element);
            System.out.printf("Добавлен %s элемент", element);
        }
    }

    public void addAll2(List<T> list) {
        list.addAll(list);
    }

    public List<T> showAll() {
        List<T> newList = new LinkedList<>();
        newList.addAll(List.of(array));
        return newList;
    }

    //    @Override
//    public void sort() {
//        for (int i = 0; i < listCats.size() - 1; i++) {
//            boolean swapped = false;
//            for (int j = 0; j <listCats.size() - 1 - i; j++) {
//                if ((Comparable<T>) listCats.get(j).compareTo(listCats.get(j+1)) > 0) {
//                    T temp = listCats.get(j);
//                    listCats.set(j, listCats.get(j+1));
//                    listCats.set(j+1, temp);
//                    swapped = true;
//                }
//            }
//            if (!swapped) {
//                break;
//            }
//        }
//    }
    public void sort() {
        for (int i = 0; i < array.length - 1; i++) {
            boolean finish;
            do {
                finish = true;
                for (int j = 0; j < array.length - 1 - i; j++) {
                    if (((Comparable<T>) array[j]).compareTo(array[j + 1]) > 0) {
                        T temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                        finish = false;
                    }
                }
            }
            while (!finish);
            {
                break;
            }
        }
    }
}

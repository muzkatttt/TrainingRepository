package hwLesson5;

import java.util.Arrays;
import java.util.Collection;

public class MyCollection<T> implements Comparable {
    private T[] array;
    private int size;

    public MyCollection() {
        array = (T[]) new Object[10];
        size = 0;
    }

    public int getSize() {
        return size;
    }

    // конструктор копирования
    public MyCollection(Collection<T> collection) {
        array = (T[]) collection.toArray();
        size = collection.size();
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

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Выход за пределы массива");
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        System.out.printf("Удален элемент с индексом %s\n", index);
    }

    public void addAll(MyCollection<String> copyList) {
        if (size + copyList.size > array.length) {
            array = Arrays.copyOf(array, size + copyList.size);
        }
        for (int i = 0; i < copyList.size; i++) {
            array[size++] = (T) copyList.get(i);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < getSize(); i++) {
            sb.append(array[i]);
            if (i < getSize() - 1) {
                sb.append(", ");
            }
        }
        sb.append('.');
        return sb.toString();
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }



}

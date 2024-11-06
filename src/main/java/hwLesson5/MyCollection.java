package hwLesson5;

import java.util.Arrays;
import java.util.Collection;

public class MyCollection<T> implements MyInterface<T>, Sort<T> {
    private T[] array;
    private int size = 0;
    private int VALUE_OF_EXTEND = 2;

    public MyCollection(int length) {
        array = (T[]) new Object[length];
    }

    public int getSize() {
        return size;
    }

    // конструктор копирования
    public MyCollection(Collection<? extends T> collection) {
        array = (T[]) new Object[size];
        size = collection.size();
        int i = 0;
        for (T elem : collection) {
            i++;
            array[i] = elem;
        }
    }

    /**
     * Метод добавления элементов в массив
     * @param element добавляемый элемент
     */
    public void add(T element) {
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length * VALUE_OF_EXTEND);
        }
        array[size] = element;
        size++;
    }

    /**
     * Метод, который "берет" нужный элемент
     * @param index индекс элемента
     * @return найденный элемент
     *{@literal |x|} - как пример применения литералов для отображения в документации к методу
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Выход за пределы массива");
        }
        return array[index];
    }

    /**
     * Метод удаления элемента по индексу
     * @param index индекс элемента
     */
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


    /**
     * Метод добавления всех элементов массива в другой массив
     * @param copyList
     */
    public void addAll(MyCollection<T> copyList) {
        if (size + copyList.size > array.length) {
            array = Arrays.copyOf(array, size + copyList.size);
        }
        for (int i = 0; i < copyList.size; i++) {
            array[size++] = (T) copyList.get(i);
        }
    }

    /**
     * Метод для демонстрации всех элементов массива
     */
    public void showAll() {
        for (T el : array) {
            System.out.print(el + " ");
        }
        System.out.println("\n");
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

    /**
     * Метод сортировки методом пузырька
     */
    @Override
    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            boolean finish;
            do {
                finish = true;
                for (int j = 0; j < size - 1 - i; j++) {
                    if (((Comparable<T>) array[j]).compareTo(array[j + 1]) > 0) {
                        T temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                        finish = false;
                    }
                }
            }
            while (!finish); {
                System.out.println("Коллекция отсортирована:");
                break;
            }
        }
    }
}




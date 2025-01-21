package ru.aston.hw1Intensive;

import java.util.Arrays;
import java.util.Comparator;

public class NameSurname2<E> implements IntensiveList<E> {

    private Object[] array;
    private int size;
    private int VALUE_OF_EXTEND = 2;
    private static final int DEFAULT_CAPACITY = 10;


    public NameSurname2() {
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public int size() {
        return array.length;
        // return size;
    }


    @Override
    public void add(E element) {
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length * VALUE_OF_EXTEND);
        }
        array[size] = element;
        size++;
    }


    //    private void increaseCapacity() {
//        int newCapacity = array.length * 2;
//        Object[] newArray = new Object[newCapacity];
//        System.arraycopy(array, 0, newArray, 0, size);
//        array = newArray;
//    }
    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == array.length) {
            //increaseCapacity();
            array = Arrays.copyOf(array, array.length * VALUE_OF_EXTEND);
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        size++;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (E) array[index];
    }

    @Override
    public E set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        E value = (E) array[index];
        array[index] = element;
        return value;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        E oldValue = (E) array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
        return oldValue;
    }

    @Override
    public void clear() {
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public void quickSort(Comparator<E> comparator) {

    }


//    @Override
//    public void quickSort(Comparator<E> comparator, Object[] array) {
//       // Collections.sort(list, comparator);
//    }

    @Override
    public boolean isSorted() {
        return false;
    }

    @Override
    public void split(int size) {

    }


    //public static void quickSort(int[] array, int startPosition, int endPosition) {
//            int leftPosition = startPosition;
//            int rightPosition = endPosition;
//            int pivot = array[(startPosition + endPosition) / 2];
//            do {
//                while (array[leftPosition] < pivot) {
//                    leftPosition++;
//                }
//                while (array[rightPosition] > pivot) {
//                    rightPosition--;
//                }
//                if (leftPosition <= rightPosition) {
//                    if (leftPosition < rightPosition) {
//                        int temp = array[leftPosition];
//                        array[leftPosition] = array[rightPosition];
//                        array[rightPosition] = temp;
//                    }
//                    leftPosition++;
//                    rightPosition--;
//                }
//            } while (leftPosition <= rightPosition);
//            if (leftPosition < endPosition) {
//                quickSort(array, leftPosition,endPosition);
//            }
//            if (startPosition < rightPosition) {
//                quickSort(array, startPosition, rightPosition);
//            }
//        }
//    @Override
//    public boolean isSorted() {
//        for (int i = 1; i < array.length; i++) {
//            if (((Comparable) list.get(i - 1)).compareTo(list.get(i)) > 0) {
//                return false;
//            }
//        }
//        return true;
//    }

//    @Override
//    public void split(int size) {
//
//    }
}


// коллекция с массивом внутри
//public class ArrayList_NameSurname<E> implements IntensiveList<E> {
//    private Object[] array;
//    private int size;
//    private static final int DEFAULT_CAPACITY = 10;
//
//    public ArrayList_NameSurname() {
//        array = new Object[DEFAULT_CAPACITY];
//        size = 0;
//    }
//
//    @Override
//    public int size() {
//        return size;
//    }
//
//    @Override
//    public void add(E element) {
//        if (size == array.length) {
//            increaseCapacity();
//        }
//        array[size++] = element;
//    }
//
//    @Override
//    public void add(int index, E element) {
//        if (index < 0 || index > size) {
//            throw new IndexOutOfBoundsException();
//        }
//        if (size == array.length) {
//            increaseCapacity();
//        }
//        System.arraycopy(array, index, array, index + 1, size - index);
//        array[index] = element;
//        size++;
//    }
//
//    @Override
//    public E get(int index) {
//        if (index < 0 || index >= size) {
//            throw new IndexOutOfBoundsException();
//        }
//        return (E) array[index];
//    }
//
//    @Override
//    public E set(int index, E element) {
//        if (index < 0 || index >= size) {
//            throw new IndexOutOfBoundsException();
//        }
//        E oldValue = (E) array[index];
//        array[index] = element;
//        return oldValue;
//    }
//
//    @Override
//    public E remove(int index) {
//        if (index < 0 || index >= size) {
//            throw new IndexOutOfBoundsException();
//        }
//        E oldValue = (E) array[index];
//        System.arraycopy(array, index + 1, array, index, size - index - 1);
//        size--;
//        return oldValue;
//    }
//
//    @Override
//    public void clear() {
//        array = new Object[DEFAULT_CAPACITY];
//        size = 0;
//    }
//
//    @Override
//    public void quickSort(Comparator<E> comparator) {
//        // Implementation of quick sort
//    }
//
//    @Override
//    public boolean isSorted() {
//        // Implementation of checking if the list is sorted
//        return false;
//    }
//
//    @Override
//    public void split(int size) {
//        // Implementation of splitting the list
//    }
//
//    private void increaseCapacity() {
//        int newCapacity = array.length * 2;
//        Object[] newArray = new Object[newCapacity];
//        System.arraycopy(array, 0, newArray, 0, size);
//        array = newArray;
//    }
//}
package ru.aston.hwLesson5;

public interface Sort<T> {
    static <T extends Comparable<? super T>> void sort1(MyCollection<T> collection) {
    }

}



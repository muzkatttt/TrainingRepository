package hwLesson5;

public interface MyInterface<T> {

    void sort();

    static <T extends Comparable<? super T>> void bubbleSort(MyInterface<T> list) {
        if (list instanceof MyCollection<T> list2) {
            list2.sort();

        }
    }
}



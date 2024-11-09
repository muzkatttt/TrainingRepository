package threads;

import java.util.HashSet;

public class ThreadsRunner {
    public static void main(String[] args) {
        ObservableSet<Integer> set = new ObservableSet<Integer>(
                new HashSet<Integer>());
        set.addObserver((s, e) -> System.out.println(e));
        for (int i = 0; i < 100; i++)
            set.add(i);
    }

}

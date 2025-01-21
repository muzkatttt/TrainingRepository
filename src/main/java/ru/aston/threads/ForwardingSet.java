package ru.aston.threads;

import java.util.Collection;
import java.util.HashSet;

public abstract class ForwardingSet<E> {
    public ForwardingSet(HashSet<Integer> set) {
        this.set = set;
    }

    HashSet<Integer> set;

    boolean add(E element) {
        return false;
    }

    boolean addAll(Collection<? extends E> c) {
        return false;
    }

}

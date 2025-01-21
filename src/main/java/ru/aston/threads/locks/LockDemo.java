package ru.aston.threads.locks;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LockDemo {
    public static void main(String[] args) {
        Map<Integer, String> hashMap = new ConcurrentHashMap<>();
        hashMap.put(1, "Value");
    }
}

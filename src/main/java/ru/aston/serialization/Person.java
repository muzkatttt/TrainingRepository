package ru.aston.serialization;

import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 1L; // статики не считываются пр исериализации
    // но присвоение номера при считывании обеспечивает проверку соответствия объекта

    private int age;
    private transient String firstName;
    private Client client;

    public Person(int age, String firstName) {
        this.age = age;
        this.firstName = firstName;
    }

    public Person(int age, Person person, String firstName) {
        this.age = age;
        this.firstName = firstName;
    }

    public Person(int age, String firstName, Client client) {
        this.client = client;
        this.age = age;
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", firstName='" + firstName + '\'' +
                ", client=" + client +
                '}';
    }
}

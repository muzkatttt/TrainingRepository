package ru.aston.threads.philosofersemafore;

public class Fork {
    private static int generator = 1;
    private int id;
    public Fork() {
        this.id = generator++;
    }

    @Override
    public String toString() {
        return "Fork{" +
                "id=" + id +
                '}';
    }
}

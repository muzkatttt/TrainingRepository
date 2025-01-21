package ru.aston.threads;

public class ThreadsDemo {
    public static void main(String[] args) {
        //SimpleThread simpleThread = new SimpleThread();
        var simpleThread = new SimpleThread();
        System.out.println(simpleThread.getName() + ": " + simpleThread.getState());
        //SimpleRunnable simpleRunnable = new SimpleRunnable();
        // до java 8
        //Thread runnableThread = new Thread(new SimpleRunnable());
        /*с java 9 можно использовать var - но только для локальных переменных
        var позволяет выровнять код, и может применяться, если ссылки на объект слева
        и справа совпадают
         */
        var runnableThread = new Thread(new SimpleRunnable(), "MyThread Name");
        System.out.println(runnableThread.getName() + ": " + runnableThread.getState());


        var lambdaThread = new Thread(() -> System.out.println("Hello from lambda:" + Thread.currentThread().getName()));
        // запустить выполнение метода в новом потоке
        simpleThread.start();
        System.out.println(simpleThread.getName() + ": " + simpleThread.getState());
        runnableThread.start();
        lambdaThread.start();
        // поток, вызвавший метод,
        // будет выполнять и блокировать переход на другой поток
        // и будет работать, пока сам не остановится
        try {
            simpleThread.join();
            System.out.println(simpleThread.getName() + ": " + simpleThread.getState());
            runnableThread.join();
            lambdaThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}

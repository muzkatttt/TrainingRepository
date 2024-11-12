package threads.list;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        //List<Integer> integers = Collections.synchronizedList(new ArrayList<>());
        List<Integer> integers = new ArrayList<>();


        String value = "new string";
        String substring = value.substring(3); // создается новый объект начиная с 3 символа строки value

        ListThread listThread1 = new ListThread(integers);
        ListThread listThread2 = new ListThread(integers);
        ListThread listThread3 = new ListThread(integers);
        ListThread listThread4 = new ListThread(integers);
        ListThread listThread5 = new ListThread(integers);
        ListThread listThread6 = new ListThread(integers);
        ListThread listThread7 = new ListThread(integers);
        ListThreads2 listThreads2 = new ListThreads2(integers);

        listThread1.start();
        listThread2.start();
        listThread3.start();
        listThread4.start();
        listThread5.start();
        listThread6.start();
        listThread7.start();
        listThreads2.run();


        try {
            listThread1.join();
            listThread2.join();
            listThread3.join();
            listThread4.join();
            listThread5.join();
            listThread6.join();
            listThread7.join();
            listThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(integers);


    }
}

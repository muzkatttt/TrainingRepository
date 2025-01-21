package ru.aston.threads.volat;

public class VolatileDemo {
    /* [RAM     flag=false]
    2 ядра
    1 ------ [flag=false]

    2 ------ [flag=true]
     */
    private static volatile boolean flag = false;
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()-> {
            while (!flag){
                System.out.println("я все еще false");
            }
        });
        thread.start();

        Thread.sleep(1L);

        Thread thread2 = new Thread(()-> {
            flag = true;
            System.out.println("flag стал true");
        });
        thread2.start();
    }
}

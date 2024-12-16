package hw1Intensive;

public class ListRunner {
    public static void main(String[] args) {
        NameSurname<Integer> nameSurname = new NameSurname<>();

        nameSurname.add(1);
        nameSurname.add(2);
        nameSurname.add(3);
        nameSurname.add(4);
        nameSurname.add(5);
        nameSurname.add(6);
        nameSurname.add(7);
        nameSurname.add(8);

        nameSurname.add(1, 6);

        final int size = nameSurname.size();
        System.out.println(size);

    }
}

package hwLesson5;


import java.util.ArrayList;
import java.util.List;

public class HwLes5 {
    public static void main(String[] args) {
//        LinkedListCatsCollection cats = new LinkedListCatsCollection<>();
//        cats.add("cat Karamel`ka");
//        cats.add("cat Barny");
//        cats.add("cat Kotofey");
//        cats.add("cat Pel`meshka");
//        cats.add("cat Rysya");
//
//        System.out.println(cats.get(3));
//        System.out.println(cats.showAll());
//
//        cats.remove("cat Barny");
//        System.out.println(cats.showAll());


        MyCollection<String> list = new MyCollection<>();
        list.add("Karamel`ka");
        list.add("Barny");
        list.add("Kotofey");
        list.add("Pel`meshka");
        list.add("Rysya");

        System.out.printf("Список:%s", list);
        System.out.println(list.get(0));
        list.remove(0);
        System.out.println(list);

        MyCollection<String> copyList = new MyCollection<>();
        copyList.add("Cat3");
        copyList.add("Another cat");
        copyList.addAll(list);
        ArrayList<String> array = new ArrayList<>();
        array.add("8sdf");
        array.add("hjkoljhgb");
        array.add("17");
        System.out.println(copyList);
        //MyCollection.bubbleSort(array);

    }
}

package ru.aston.generics;

public class MyGenerics {
    public static void main(String[] args) {
//        AnyList anyList = new AnyList(10);
//
//        anyList.add("String");
//        anyList.add(22);
//        anyList.add(22);
//
//        String o = (String) anyList.get(1);
//        o.length();

        GenList<Double> genList = new GenList<>(10);
        genList.add(22.2);

        putSingel(22.2);

        putList2(new GenList<Object>(10));

        putArr(new Double[]{});

    }

    // Инварианты
    static void putList1(GenList<Number> list) {

    }

    // Контравариантность
    static void putList2(GenList<? super Number> list) {

    }

    // Коварианты
    static void putArr(Number[] arr) {
        //GenList<? extends Number> list

    }

    static void putSingel(Number num) {
        System.out.println(num);
    }
}

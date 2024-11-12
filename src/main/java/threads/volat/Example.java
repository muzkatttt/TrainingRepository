package threads.volat;

import java.util.ArrayList;
import java.util.List;

public class Example {
    private List<Integer> list;

    public Example(List<Integer> list) {
        //this.list = List.copyOf(list); // для того, чтобы создавать  неизменяемые объекты
        this.list = list;
    }

//    public List<Integer> getList() {
//        return list;
//    }

    public synchronized List<Integer> getList() {
        return new ArrayList<>(list);
        //return list;
    }
}

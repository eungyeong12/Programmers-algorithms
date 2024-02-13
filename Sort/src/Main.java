import java.util.*;

class MyData implements Comparable<MyData> {
    int v;

    public MyData(int v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return String.valueOf(v); // ""+v;
    }

    @Override
    public int compareTo(MyData o) {
        return Integer.compare(v, o.v); // v-o.v;
    }
}

public class Main {

    public static void main(String[] args) {
        List<MyData> list = new LinkedList<>();
        Random r = new Random();
        for(int i=0; i<20; i++) list.add(new MyData(r.nextInt(20)));

        list = new BubbleSort().sort(list);
        System.out.println(list);

        list = new LinkedList<>();
        r = new Random();
        for(int i=0; i<20; i++) list.add(new MyData(r.nextInt(20)));
        list = new InsertSort().sort(list);
        System.out.println(list);

        list = new LinkedList<>();
        r = new Random();
        for(int i=0; i<20; i++) list.add(new MyData(r.nextInt(20)));
        list = new SelectionSort().sort(list);
        System.out.println(list);

        list = new LinkedList<>();
        r = new Random();
        for(int i=0; i<20; i++) list.add(new MyData(r.nextInt(20)));
        list = new MergeSort().sort(list);
        System.out.println(list);

        list = new LinkedList<>();
        r = new Random();
        for(int i=0; i<20; i++) list.add(new MyData(r.nextInt(20)));
        list = new QuickSort().sort(list);
        System.out.println(list);
    }
}
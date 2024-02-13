import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

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
        List<Integer> list = new LinkedList<>();

        Random r = new Random();
        for(int i=0; i<20; i++) list.add(r.nextInt(50));

        list.sort(Comparator.naturalOrder()); // 오름차순
        list.sort(Comparator.reverseOrder()); // 내림차순
        list.sort(new Comparator<Integer>() { // 오름차순
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        list.sort((o1, o2) -> o2.compareTo(o1)); // 내림차순
        System.out.println(list);

        List<MyData> list2 = new LinkedList<>();

        for(int i=0; i<20; i++) list2.add(new MyData(r.nextInt(50)));

        list2.sort(new Comparator<MyData>() {
            @Override
            public int compare(MyData o1, MyData o2) {
                return o1.v - o2.v;
            }
        });

        list2.sort(Comparator.naturalOrder());
        System.out.println(list2);

        List<MyData> list3 = new LinkedList<>();

        for(int i=0; i<20; i++) list3.add(new MyData(r.nextInt(50)));

        list3 = quickSort(list3);
        System.out.println(list3);
    }

    static List<MyData> quickSort(List<MyData> list) {
        if(list.size() <= 1) return list;
        MyData pivot = list.remove(0);

        List<MyData> lesser = new LinkedList<>();
        List<MyData> greater = new LinkedList<>();

        for(MyData m : list) {
            if(pivot.compareTo(m) > 0) lesser.add(m);
            else greater.add(m);
        }

        List<MyData> merged = new LinkedList<>();
        merged.addAll(quickSort(lesser));
        merged.add(pivot);
        merged.addAll(quickSort(greater));

        return merged;
    }
}
import java.util.*;

// search는 indexOf, contains, remove 같은 곳에서 이미 구현되어 있다.
// equals가 제공될 필요가 있다.
// 이진탐색 : Collections.binarySearch
// Comparable가 구현되어 있어야 한다.
// 순서대로 정렬되어 있어야 한다.

class MyData implements Comparable<MyData> {
    int v;

    public MyData(int v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return ""+v;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyData myData = (MyData) o;
        return v == myData.v;
    }

    @Override
    public int hashCode() {
        return Objects.hash(v);
    }

    @Override
    public int compareTo(MyData o) {
        // 1 == 1 : 1 - 1 == 0 : 같다.
        // 1 ? 2 : 1 - 2 == 0 : 같다.
        //                < 0 : 오른쪽 것이 크다.
        //                < 0 : 왼쪽 것이 크다.
        return v - o.v;
    }
}

public class Main {
    public static void main(String[] args) {
        List<MyData> list = new LinkedList<>();

        Random r = new Random();
        for(int i=1; i<=100; i++) list.add(new MyData(r.nextInt(100)));
        System.out.println(list);

        int index2 = Collections.binarySearch(list, new MyData(63));

        int index = list.indexOf(new MyData(63));
        System.out.println(index2);
        System.out.println(list.get(index2));
    }
}
import java.util.*;

class MyData {
    int v;
    public MyData(int v) {
        this.v = v;
    }
    @Override
    public String toString() {
        return "" + v;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        MyData myData = (MyData) o;
        return v == myData.v;
    }

    @Override
    public int hashCode() {
        return Objects.hash(v);
    }
}

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();

        if(!list.contains(1)) list.add(1);
        if(!list.contains(2)) list.add(2);
        if(!list.contains(3)) list.add(3);

        if(!list.contains(1)) list.add(1);
        if(!list.contains(2)) list.add(2);
        if(!list.contains(3)) list.add(3);

        System.out.println(list);

        Set<MyData> setA = new LinkedHashSet<>(); // set은 순서를 보장하지 않는다.
        Set<MyData> setB = new LinkedHashSet<>();

        // A
        setA.add(new MyData(1));
        setA.add(new MyData(2));
        setA.add(new MyData(3));

        // B
        setB.add(new MyData(2));
        setB.add(new MyData(3));
        setB.add(new MyData(4));

        // A+B
        setA.addAll(setB);
        System.out.println(setA);

        // A-B
        setA.removeAll(setB);
        System.out.println(setA);

        // A*B
        setA.retainAll(setB);
        System.out.println(setA);
    }
}
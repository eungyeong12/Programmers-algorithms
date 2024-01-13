import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

// LinkedList
// List 인터페이스
// 인덱스로 값을 접근할 경우 LinkedList보다 ArrayList나 Vector가 유리 
// ArrayList (not synch)
// Vector (synch)

class MyData {
    int value;
    public MyData(int value) {
        this.value = value;
    }
    static MyData create(int v) {
        return new MyData(v);
    }

    public String toString() {
        return ""+value;
    }

    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null | getClass() != o.getClass()) return false;
        MyData myData = (MyData) o;
        return value == myData.value;
    }
}
public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1, 5);
        list.remove(2);
        System.out.println(list); // [1, 5, 3]
        System.out.println(list.get(2));
        System.out.println(list.contains(5));

        //LinkedList<MyData> list2 = new LinkedList<>();
        List<MyData> list2 = new LinkedList<>();
        list2.add(MyData.create(1));
        list2.add(MyData.create(2));
        list2.add(MyData.create(3));
        System.out.println(list2);
        System.out.println(list2.contains(MyData.create(2))); // true
        System.out.println(list2.indexOf(MyData.create(3)));
        System.out.println(list2.size());
        System.out.println(list2.isEmpty());


        List<MyData> list3 = new Vector<>(); // 벡터형인데 리스트형으로 표현 가능하다. 다형성
        method1(list3);

        List<MyData> list4 = new ArrayList<>();
        method1(list4);
    }

    static void method1(List<MyData> list) {
        System.out.println(list);
        System.out.println(list.get(2));
        System.out.println(list.size());
        System.out.println(list.isEmpty());
    }
}
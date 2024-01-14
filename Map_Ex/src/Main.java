import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

// Array 장점 + List 장점 => 유연하면서도 빠르게 값을 찾아낼 수 있는
// Map : key -> hash function -> hash -> bucket index -> List -> Data
// Map<K,V>
// HashMap : not synch
// Hashtable : synch
// ConcurrentHashMap : synch + high concurrency

class MyData {
    int v;
    public MyData(int v) {
        this.v = v;
    }
    public String toString() {
        return "["+v+"]";
    }
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        MyData myData = (MyData) o;
        return v == myData.v;
    }

    public int hashCode() {
        return Objects.hash(v);
    }
}

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> map = new Hashtable<>();
        map.put("A", 1);
        map.put("B", 2);
        map.putIfAbsent("A", 10);
        map.remove("B", 3); // value 값이 같지 않으므로 삭제되지 않는다.
        map.replace("A", 10, 11); // A가 10이라면 11로 바꿔라.
        method1(map);

        Map<String, Integer> map2 = new HashMap<>();

        Map<MyData, Integer> map3 = new ConcurrentHashMap<>();
        map3.put(new MyData(1), 1);
        map3.put(new MyData(2), 2);
        map3.replace(new MyData(1), 1, 11);
        method2(map3);
    }

    static void method1(Map<String, Integer> map) {
        System.out.println(map);
        System.out.println(map.get("A")); // 1
        System.out.println(map.getOrDefault("C", -1)); // -1
        System.out.println(map.values());
        System.out.println(map.keySet());
    }

    static void method2(Map<MyData, Integer> map) {
        System.out.println(map.remove(new MyData(2), 3)); // false
        System.out.println(map);
        System.out.println(map.get(new MyData(1)));
        System.out.println(map.getOrDefault(new MyData(3), -1)); // -1
        System.out.println(map.values());
        System.out.println(map.keySet());
    }
}
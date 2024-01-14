import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // 생성과 함께 초기값 지정하기
        Map<String, Integer> map = new HashMap<>() {{
            put("A", 1);
            put("B", 2);
            put("C", 3);
        }};

        // entrySet 사용하여 맵의 모든 값 순회하기
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        // keySet 사용하여 맵의 모든 값 순회하기
        for(String key : map.keySet()) {
            System.out.println(key + ":" + map.get(key));
        }

        // Iterator 사용하여 맵의 모든 값 순회하기
        var iter = map.entrySet().iterator();
        while(iter.hasNext()) {
            var entry = iter.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
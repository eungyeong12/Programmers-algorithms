import java.util.*;
import java.util.stream.Collectors;

public class Main {

    // 합집합 만들기
    <T> List<T> union(List<T> list1, List<T> list2) {
        List<T> union = new LinkedList<>();
        union.addAll(list1);
        for(T t : list2) if(!union.contains(t)) union.add(t);
        return union;
    }

    // 차집합 만들기
    <T> List<T> difference(List<T> list1, List<T> list2) {
        List<T> difference = new LinkedList<>();
        difference.addAll(list1);
        for(T t : list2) difference.remove(t);
        return difference;
    }

    // 교집합 만들기
    <T> List<T> intersection(List<T> list1, List<T> list2) {
        List<T> intersection = new LinkedList<>();
        for(T t : list1) if(list2.contains(t)) intersection.add(t);
        return intersection;
    }
    
    public static void main(String[] args) {
        // List의 중복요소 제거하기
        List<String> list = Arrays.asList("A", "B", "C", "D", "A", "B", "C");
        Set<String> set = new HashSet<>(list);
        System.out.println(set); // [A, B, C]

        List<String> list2 = Arrays.asList("A", "B", "C", "D", "A", "B", "C");
        Set<String> set2 = new HashSet<>(list2);
        List<String> list3 = new LinkedList<>(set2);
        System.out.println(list3);

        List<String> list4 = Arrays.asList("A", "B", "C", "D", "A", "B", "C");
        List<String> list5 = list.stream().distinct().collect(Collectors.toList());
        System.out.println(list5); // [A, B, C]

    }
}
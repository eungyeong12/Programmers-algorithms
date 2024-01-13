import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 고정 값으로 List 만들기
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        // 리스트의 값을 변경할 수는 있지만, 크기에 영향을 주는 추가/삭제 작업은 할 수 없다.
        list1.set(0, 6); // 가능
        list1.add(6); // error
        list1.remove(0); // error

        // Array로 List 만들기
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5};
        List<Integer> list2 = Arrays.asList(arr);

        // List로부터 List 만들기
        List<Integer> list3 = new LinkedList<>(list1);

        // List를 Array로 변경하기
        List<Integer> list4 = Arrays.asList(1, 2, 3, 4, 5);
        int[] arr2 = new int[list4.size()];
        for(int i=0; i<list4.size(); i++) {
            arr2[i] = list4.get(i);
        }

        List<String> list5 = Arrays.asList("A", "B", "C", "D", "E");
        String[] arr3 = list5.toArray(String[]::new);

        List<Integer> list6 = Arrays.asList(1, 2, 3, 4, 5);
        Integer[] arr4 = list6.toArray(Integer[]::new);

        List<String> list7 = Arrays.asList("A", "B", "C", "D", "E");
        String[] arr5 = list7.stream().toArray(String[]::new);

        List<Integer> list8 = Arrays.asList(1, 2, 3, 4, 5);
        int[] arr6 = list8.stream().mapToInt(Integer::intValue).toArray();

        // 리스트 요소 삭제하기
        List<Integer> list9 = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        for(int i=0; i<list9.size(); i++) {
            list9.remove(i); // 삭제할 때마다 size가 줄어들어 index가 고정되지 않기 때문에 예상대로 동작하지 않는다.
        }
        System.out.println(list9); // [2, 4]

        // call by reference
        List<Integer> list10 = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        updateList(list10);
        System.out.println(list10); // [2, 4, 6, 8, 10]
        updateList(Collections.unmodifiableList(list10)); // 리스트의 내용을 변경할 수 없다.
    }

    static void updateList(final List<Integer> list) {
        for(int i=0; i<list.size(); i++) {
            list.set(i, list.get(i)*2);
        }
    }
}
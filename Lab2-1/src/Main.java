import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        /*
        주어진 입력중 최대값을 구하고, 최대값이 이 위치하는 index 값의 목록을 반환하세요.

        입력:
        [1, 3, 5, 4, 5, 2, 1]

        입력된 목록의 최대값은 5입니다.
        5와 동일한 값을 가진 위치는 3번째, 5번째 위치 입니다.
        이 위치에 해당하는 index는 [2, 4] 입니다.

        출력:
        [2, 4]
        */
        int[] arr = {1, 3, 5, 4, 5, 2, 1};
        System.out.println(Arrays.toString(solution(arr)));
    }
    static int[] solution(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();

        return IntStream.range(0, arr.length)
                .filter(i -> arr[i] == max)
                .toArray();
    }
}
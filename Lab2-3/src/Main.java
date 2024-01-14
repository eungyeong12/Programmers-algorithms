import javax.swing.event.ListSelectionListener;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*
        자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요.
        예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.
         */
        long n = 12345;
        System.out.println(Arrays.toString(solution(n)));
    }

    static int[] solution(long n) {
        List<Integer> list = new LinkedList<>();

        while(n > 0) {
            list.add((int)(n%10));
            n /= 10;
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
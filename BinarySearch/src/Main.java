import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        System.out.println(binarySearch(list, 4));
    }
    static <T extends Comparable> T binarySearch(List<T> data,T target) {
        int min = 0;
        int max = data.size();
        while(min < max) {
            int mid = (max - min) / 2 + min;
            T m = data.get(mid);

            int c = m.compareTo(target);
            if(c == 0) return m;
            else if(c < 0) min = mid + 1;
            else max = mid;
        }
        return null;
    }
}
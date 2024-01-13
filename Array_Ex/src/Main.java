import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[5];
        String[] strs = new String[5];
        boolean[] bools = new boolean[5];
        System.out.println(arr); // arr의 주소
        System.out.println(Arrays.toString(arr)); // 0으로 초기화
        System.out.println(Arrays.toString(strs)); // null로 초기화
        System.out.println(Arrays.toString(bools)); // false로 초기화

        arr[0] = 1;
        arr[arr.length-1] = 5;
        System.out.println(Arrays.toString(arr));
        System.out.println(arr[0]);
        System.out.println(arr.length);

        // Array
        // 여러 개의 데이터를 한꺼번에 다룰 수 있다.
        // Array는 Object는 아니지만 Reference Value로 취급된다.
        // 메모리상에 연달아 공간을 확보한다.
        // 미리 공간을 확보해 놓고 써야 한다.
        // 한 번 만들어진 공간은 크기가 고정된다.
        // 첫 번째 위치만 알면 index로 상대적 위치를 빠르게 찾을 수 있다. 
    }
}
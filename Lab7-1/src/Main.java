/*
정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수, solution을 완성해주세요. 단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요. 예를들어 arr이 [4,3,2,1]인 경우는 [4,3,2]를 리턴 하고, [10]면 [-1]을 리턴 합니다.

제한 조건
arr은 길이 1 이상인 배열입니다.
인덱스 i, j에 대해 i ≠ j이면 arr[i] ≠ arr[j] 입니다.
입출력 예
arr	return
[4,3,2,1]	[4,3,2]
[10]	[-1]
 */

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = {4,7,3,5,6,8,1,9};
        int[] arr2 = {10};
        System.out.println(Arrays.toString(solution(arr1)));
        System.out.println(Arrays.toString(solution(arr2)));
    }

    public static int[] solution(int[] arr) {
        int[] answer;
        if(arr.length == 1) {
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        answer = new int[arr.length-1];
        int min = Arrays.stream(arr).min().getAsInt();
        int index = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] != min)
                answer[index++] = arr[i];
        }
        return answer;
    }

    static int[] solution2(int[] arr) {
        if(arr.length == 1) return new int[]{-1};

        int min = Arrays.stream(arr).min().getAsInt();

        int[] answer = new int[arr.length-1];
        int index = 0;
        for(int a : arr) {
            if(a == min) continue;
            answer[index++] = a;
        }
        return answer;
    }

    static int[] solution3(int[] arr) {
        if(arr.length == 1) return new int[]{-1};

        int min = Arrays.stream(arr).min().getAsInt();
        return Arrays.stream(arr)
                .filter(a -> a != min)
                .toArray();
    }
}
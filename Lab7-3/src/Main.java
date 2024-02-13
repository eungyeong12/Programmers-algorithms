/*
문제 설명
JadenCase란 모든 단어의 첫 문자가 대문자이고, 그 외의 알파벳은 소문자인 문자열입니다. 단, 첫 문자가 알파벳이 아닐 때에는 이어지는 알파벳은 소문자로 쓰면 됩니다. (첫 번째 입출력 예 참고)
문자열 s가 주어졌을 때, s를 JadenCase로 바꾼 문자열을 리턴하는 함수, solution을 완성해주세요.

제한 조건
s는 길이 1 이상 200 이하인 문자열입니다.
s는 알파벳과 숫자, 공백문자(" ")로 이루어져 있습니다.
숫자는 단어의 첫 문자로만 나옵니다.
숫자로만 이루어진 단어는 없습니다.
공백문자가 연속해서 나올 수 있습니다.
입출력 예
s	return
"3people unFollowed me"	"3people Unfollowed Me"
"for the last week"	"For The Last Week"
 */

public class Main {
    public static void main(String[] args) {
        String s = "3people unFollowed me";
        System.out.println(solution(s));
    }

    public static String solution(String s) {
        String answer = "";
        s = s.toLowerCase();
        answer += Character.toUpperCase(s.charAt(0));
        for(int i=1; i<s.length(); i++) {
            if(s.charAt(i-1) == ' ')
                answer += Character.toUpperCase(s.charAt(i));
            else
                answer += s.charAt(i);
        }
        return answer;
    }

    public static String solution2(String s) {
        String answer = "";
        String s2 = s.toLowerCase();
        char last = ' ';
        for(char c : s2.toCharArray()) {
            if(last == ' ') c = Character.toUpperCase(c);
            answer += c;
            last = c;
        }
        return answer;
    }

    public static String solution3(String s) {
        StringBuilder sb = new StringBuilder();
        String s2 = s.toLowerCase();
        char last = ' ';
        for(char c : s2.toCharArray()) {
            if(last == ' ') c = Character.toUpperCase(c);
            sb.append(c);
            last = c;
        }
        return sb.toString();
    }
}
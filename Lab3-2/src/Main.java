import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*
        수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.

        마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.

        제한사항
        마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
        completion의 길이는 participant의 길이보다 1 작습니다.
        참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
        참가자 중에는 동명이인이 있을 수 있습니다.
         */
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        System.out.println(solution(participant, completion));
        System.out.println(solution2(participant, completion));
    }

    static String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> players = new HashMap<>();
        for(String p : participant)
            players.put(p, players.getOrDefault(p,0)+1);
        for(String c : completion) {
            int n = players.get(c) - 1;
            if(n == 0)
                players.remove(c);
            else
                players.put(c, n);
        }

        return players.keySet().iterator().next();
    }

    static String solution2(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        for(int i=0; i<completion.length; i++) {
            if(!(participant[i].equals(completion[i])))
                return participant[i];
        }
        return participant[participant.length-1];
    }
}
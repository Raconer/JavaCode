package com.java.quiz;

import java.util.HashMap;

/* 
    문제 설명
    
    수많은 마라톤 선수들이 마라톤에 참여하였습니다. 
    단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.

    마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 
    완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.

    제한사항
        * 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
        * completion의 길이는 participant의 길이보다 1 작습니다.
        * 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
        * 참가자 중에는 동명이인이 있을 수 있습니다.

    입출력 예
    participant	                                        completion	                                return
    ["leo", "kiki", "eden"]	                            ["eden", "kiki"]	                        "leo"
    ["marina", "josipa", "nikola", "vinko", "filipa"]	["josipa", "filipa", "marina", "nikola"]	"vinko"
    ["mislav", "stanko", "mislav", "ana"]	            ["stanko", "ana", "mislav"]	                "mislav"
    */
public class didNotCompletePlayers {
   
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> partList = new HashMap();
        int cnt;
        for(String part : participant){
            // partList.put(part, partList.getOrDefault(part, 0) + 1);
            cnt = 1;
            if(partList.containsKey(part)){
                cnt += partList.get(part);
            }
            partList.put(part, cnt);
        }
        for(String comp : completion){
            cnt = partList.get(comp) - 1;
            if(cnt <= 0){
                partList.remove(comp);
            }else{
                partList.put(comp, cnt);
            }
        }
        
        return partList.keySet().iterator().next();
    }

    public static void main(String[] args) {
        // 테스트 케이스 1
        String[] participant1 = {"leo", "kiki", "eden"};
        String[] completion1 = {"eden", "kiki"};
        // 테스트 케이스 2
         String[] participant2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
         String[] completion2 = {"josipa", "filipa", "marina", "nikola"};
        // 테스트 케이스 3
        String[] participant3 = {"mislav", "stanko", "mislav", "ana"};
        String[] completion3 = {"stanko", "ana", "mislav"};

        String result1 = solution(participant1, completion1);
        String result2 = solution(participant2, completion2);
        String result3 = solution(participant3, completion3);
        
        System.out.println(result1.equals("leo")?"성공":"실패");
        System.out.println(result2.equals("vinko")?"성공":"실패");
        System.out.println(result3.equals("mislav")?"성공":"실패");
    }
}

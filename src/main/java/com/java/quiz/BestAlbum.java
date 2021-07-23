package com.java.quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.event.SwingPropertyChangeSupport;

/* 
    문제 설명
        
    스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 
    노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.

        1. 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
        2. 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
        3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
    
    노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 
    베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.

    제한사항
    
    * genres[i]는 고유번호가 i인 노래의 장르입니다.
    * plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
    * genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
    * 장르 종류는 100개 미만입니다.
    * 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
    * 모든 장르는 재생된 횟수가 다릅니다.

    입출력 예
    genres	                                        plays	                    return
    ["classic", "pop", "classic", "classic", "pop"]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]
*/

public class BestAlbum {

    static Logger logger = Logger.getLogger(BestAlbum.class.getName());

    public static int[] solution(String[] genres, int[] plays) {
        List<Integer> answerList = new ArrayList<>();
        HashMap<String, Integer> dataMap = new HashMap<>();
        HashMap<String, List<Integer>> playMap = new HashMap<>();
       
        for(int i = 0; i < genres.length; i++){
            String key = genres[i];
            int value = plays[i];
            List<Integer> playValue = playMap.getOrDefault(key, new ArrayList<>());
          
            dataMap.put(key, dataMap.getOrDefault(key, 0) + value); // player 총합
            // plays index Sort 별로 add
            if(playValue.isEmpty()) playValue.add(i);
            else{
                int size = playValue.size();
   
                for(int j = 0; j < size; j++){
                    if(value > plays[playValue.get(j)]){
                        playValue.add(j, i);
                        break;
                    }else if(j == size -1){
                        playValue.add(i);   
                    }
                }
            }
            playMap.put(key, playValue);
        }
        // Value 값 기준 내림차순 Sort
        List<String> keySetList = new ArrayList<>(dataMap.keySet());
        Collections.sort(keySetList, (o1, o2) -> (dataMap.get(o2).compareTo(dataMap.get(o1))));

        for(String key : keySetList){
            List<Integer> values = playMap.get(key);
            int size = values.size();
            size = size>1?2:size;
           
            for(int i = 0; i < size; i++){
                answerList.add(values.get(i));
            }
        }
        
        return answerList.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        // String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        // int[] plays = {500, 2500, 150, 800, 2500};
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 2500, 150, 800, 2500};
        int[] answers = {4, 1, 3, 0};
        int[] results = solution(genres, plays);
        
        // logger.info(Arrays.toString(results));
        // logger.info(String.valueOf(Arrays.equals(answers, results)));
    }
}

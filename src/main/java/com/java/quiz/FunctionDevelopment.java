package com.java.quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class FunctionDevelopment {

    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answers = new ArrayList();
        int size = progresses.length;   
        int standard = 0, temp = 0;
        int cnt = 0, qSize = 0;
        
        Queue q = new LinkedList<>();
      
        for(int i = 0; i < size; i++){
            int tempValue = (100 - progresses[i]);
            int tempSpeed = speeds[i];
            int leftDate;
            
            leftDate = tempValue/tempSpeed + (tempValue%tempSpeed > 0?1:0);

            q.offer(leftDate);
        }

        qSize = q.size() - 1;
        standard = (int)q.poll();
        for(int i = 0; i <= qSize; i++){
            if(i < qSize){
                temp = (int)q.poll();
            }
            
            cnt++;
           
            if(standard < temp || (i == qSize && standard > 0)){
                standard = temp;
                answers.add(cnt);
                cnt = 0;
            }
        }
        System.out.println(answers.toString());
        return answers.stream().mapToInt(i->i).toArray();
    }
    
    public static void main(String[] args) {
        int[][] progresses = {{93, 30, 55},{95, 90, 99, 99, 80, 99},{1}};
        int[][] speeds = {{1, 30, 5},{1, 1, 1, 1, 1, 1},{1}};
        int[][] returnValues = {{2, 1},{1, 3, 2},{1}};
        int size = returnValues.length;

        for(int i = 0; i < size; i++){
            int[] progress = progresses[i];
            int[] speed = speeds[i];
            int[] returnValue = returnValues[i];
           
            System.out.println(i +" -> " + Arrays.equals(returnValue, solution(progress, speed)));
        }
    }
}

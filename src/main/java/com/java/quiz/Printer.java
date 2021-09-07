package com.java.quiz;

public class Printer {

    public static int solution(int[] priorities, int location) {
        int maxIndex = 0, maxValue = 0;
        int size = priorities.length;
        int answer = 0;
        
        for(int i = 0; i < size; i++){
            int tempValue = priorities[i];
            if(maxValue < tempValue){
                maxIndex = i;
                maxValue = tempValue;
            }
        }

       if(location < maxIndex){
            answer = location + (size - maxIndex);
        }else{
            answer = location - maxIndex ;
        }
        
        return answer + 1;
    }
    
    public static void main(String[] args) {
    int[][] prioritieList = {{2, 1, 3, 2}, {1, 1, 9, 1, 1, 1} };    
    int[]	locationList = {2,0};
    int[]	resultList = {1,5};
    int size = prioritieList.length;
    for(int i = 0; i < size; i++){
        int[] priorities = prioritieList[i];
        int location = locationList[i];
        int result = resultList[i];
        int resultValue = solution(priorities, location) ;
        System.out.println(resultValue);
        System.out.println(i +" -> " + (resultValue == result));
    }
    }
}

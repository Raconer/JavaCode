package com.java.dataStructure.sort;

public class Insert {
    public Insert(){
    }

    public static void InsertSort(int[] arr){
        for(int i = 1; i <arr.length; i++){
            int standard = arr[i];
            int temp = i-1;
            while(temp >= 0 && standard < arr[temp]){
                arr[temp + 1] = arr[temp]; 
                temp--;
            }
            arr[temp + 1] = standard;  
        }
    }
}
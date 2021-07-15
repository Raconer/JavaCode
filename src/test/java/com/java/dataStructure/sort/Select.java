package com.java.dataStructure.sort;

public class Select {
    public Select(){}

    public static void selectSort(int[] arr){
        int length = arr.length;

        for(int i = 0; i < length - 1; i++){
            for(int j = i+1; j < length; j++){
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }  
            }
        }
    }
}
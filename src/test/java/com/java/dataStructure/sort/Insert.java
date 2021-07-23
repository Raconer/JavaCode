package com.java.dataStructure.sort;

import java.util.Arrays;

public class Insert {
  
    private static CommonSort commonSort = new CommonSort();

    public static void InsertSort(int[] arr){
        int size = arr.length;
        int roundCnt = 0, swapCnt = 0;
        for(int i = 1; i < size; i++){
            for(int j = i; j > 0; j--){
                if(arr[j] < arr[j - 1]){
                    swapCnt++;
                    commonSort.swap(arr, j, j -1);
                }else{
                    break;
                }
                commonSort.indexToString(j, j - 1);
            }
            roundCnt++;
            System.out.println();
        }
        System.out.println(size + "개 Insert Sorting("+roundCnt+"라운드)  : 총" + swapCnt+"회");
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = commonSort.testIntArr();
        InsertSort(arr);
    }
}
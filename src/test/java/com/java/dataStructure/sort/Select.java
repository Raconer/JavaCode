package com.java.dataStructure.sort;

import java.util.Arrays;

public class Select {

    private static CommonSort commonSort = new CommonSort();

    public static void selectSort(int[] arr){
        int size = arr.length;
        int roundCnt = 0, swapCnt = 0;

        for(int i = 0; i < size - 1; i++) {
            int index = i;
            for(int j = i + 1; j < size; j++){
                commonSort.indexToString(index, j);
               
                if(arr[index] > arr[j]){
                    swapCnt++;
                    index = j;
                }
            }
            roundCnt++;
            commonSort.swapToString(i, index);
            commonSort.swap(arr, i, index);
            System.out.println();
        }
        System.out.println(size + "개 Select Sorting("+roundCnt+"라운드)  : 총" + swapCnt+"회");
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = commonSort.testIntArr();
        selectSort(arr);
    }
}
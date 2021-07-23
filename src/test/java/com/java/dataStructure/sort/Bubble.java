package com.java.dataStructure.sort;

import java.util.Arrays;

import javax.swing.event.SwingPropertyChangeSupport;

public class Bubble {
    
    private static CommonSort commonSort = new CommonSort();

    public static void Bubble(int[] arr){
        int size = arr.length;
        int roundCnt = 0, swapCnt = 0;
        for(int i = 1; i < size; i++) {
			for(int j = 0; j < size - i; j++) {
               
			   
                if(arr[j] > arr [j + 1]) {
                    swapCnt++;
					commonSort.swap(arr, j, j + 1);
				}
                commonSort.indexToString(j, j+1);
			}
            roundCnt++;
            System.out.println();
		}
        System.out.println(size + "개 Bubble Sorting("+roundCnt+"라운드)  : 총" + swapCnt+"회");
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = commonSort.testIntArr();
        Bubble(arr);
    }
}
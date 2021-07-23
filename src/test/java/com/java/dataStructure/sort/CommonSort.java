package com.java.dataStructure.sort;

import java.util.Arrays;

public class CommonSort {
    public void swap(int[] arr, int i, int j){
        System.out.print("swap");
        if(i != j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    public void indexToString(int i, int j){
        System.out.print("["+i+"]["+j +"]  ->");
       
    }

    public void swapToString(int i, int j){
        System.out.print("(["+i+"] <-> ["+j +"])");
    }

    public int[] testIntArr(){
        int[] arr = {6,3,8,9,3,5,9,0,12,3,4,5,6,7,8,5,2,32};
        System.out.println(Arrays.toString(arr));
        return arr;
    }

}

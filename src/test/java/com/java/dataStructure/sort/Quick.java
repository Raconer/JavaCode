package com.java.dataStructure.sort;

/* 
    Quick 정렬
    Smaller Bigger을 구분하여 계속해서 작고, 큰 부분을 나눠서 정리하는 방법
    시간 복잡도 O(n log n)
*/
public class Quick {

    public Quick(){
    }

    public void quickSort(int[] arr,int start, int end){
        int part = partition(arr, start, end);
        if(start < part -1){
            quickSort(arr, start, part-1);
        }
        if(part < end){
            quickSort(arr, part, end);    
        }
    }

    public int partition(int[] arr,int start, int end){
        int pivot = arr[(start + end)/2];
        while(start <= end){
            while(arr[start] < pivot) start++;
            while(pivot < arr[end]) end--;
            if(start <= end){
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        return start;
    }

    public void swap(int[] arr, int start, int end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

}
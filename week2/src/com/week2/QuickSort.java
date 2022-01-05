package com.week2;

import java.util.Arrays;

public class QuickSort {
    public int partition(int[] array, int begin, int end){
        int pivot = array[end];
        int i = begin-1;
        for (int j= begin; j< end; j++){
            if (array[j] < pivot){
                i++;

                // swap array[i], array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // swap array[i+1], array[end]
        int temp = array[i+1];
        array[i+1] = array[end];
        array[end] = temp;
        return i+1;
    }
    public void quickSort(int[] array, int begin, int end){
        if (begin < end){
            int pi = partition(array, begin, end);
            quickSort(array, begin, pi-1);
            quickSort(array, pi + 1, end);
        }
    }


    public static void main(String[] args){
        int[] testArray = {10, 9, 4, 2, 1, 7};
        int begin = 0;
        int end = testArray.length - 1;
        QuickSort ob = new QuickSort();
        ob.quickSort(testArray, begin, end);
        System.out.println(Arrays.toString(testArray));
    }
}

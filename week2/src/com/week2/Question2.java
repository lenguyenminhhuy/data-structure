package com.week2;

import java.util.Arrays;

// find missing value in an array
public class Question2 {
    public static int findMissingValue(int[] array, int size){
        int begin =0;
        int end = size -1;
        while ((end - begin) > 1){
            int mid = begin + (int)(end - begin)/2;
            if (array[begin] - begin != array[mid] - mid){
                end = mid;
            }
            else if (array[end] - end != array[mid] - mid){
                begin = mid;
            }
        }
        return array[begin] + 1;
    }
    public static void main(String[] args){
        int[] testArray = {0,1,2,3,5};
        System.out.println("Testing array: " + Arrays.toString(testArray));
        System.out.println("Missing value: " + findMissingValue(testArray, testArray.length));
    }
}

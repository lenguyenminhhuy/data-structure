package com.week2;

import java.util.Arrays;

public class Question5 {
    public static void findClosesSum(int[] arr){
        int leftIdx = 0;
        int rightIdx = arr.length -1;

        // variable to keep track
        int minSumLeft = leftIdx;
        int minSumRight = rightIdx;
        int finalSum = 99999; // a large number

        Arrays.sort(arr);
        while (leftIdx < rightIdx){
            int currentSum = arr[leftIdx] + arr[rightIdx];
            if (Math.abs(finalSum) > Math.abs(currentSum)){
                finalSum = currentSum;
                minSumLeft = leftIdx;
                minSumRight = rightIdx;
            }
            if (currentSum >= 0){
                rightIdx --;
            }
            else {
                leftIdx++;
            }
        }
        System.out.println(arr[minSumLeft]);
        System.out.println(arr[minSumRight]);
    }
    public static void main(String[] args){
        int[] testArray = {1, 60, -10, 87, -80, -85};
        findClosesSum(testArray);
    }
}

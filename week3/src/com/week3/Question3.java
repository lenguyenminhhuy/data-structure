package com.week3;

public class Question3 {
    static void findNewestOldestNumber(int[] array){
        int leftMost = 0;
        int rightMost = array.length - 1;
        while (leftMost < rightMost && array[leftMost] > array[rightMost]){
            int mid = (int)(rightMost + leftMost) / 2;

            if (array[mid] > array[rightMost]){
                leftMost = mid+1;
            }
            else if (array[mid] < array[leftMost]){
                rightMost = mid;
            }
        }
        System.out.println("Newest number is: " + array[leftMost]);
        System.out.println("Oldest number is: " + array[rightMost]);
    }

    public static void main(String[] args){
        int[] testArr = {113, 115, 117, 118, 10, 11, 12, 13, 20, 23, 27, 100, 103, 105, 108};
        findNewestOldestNumber(testArr);
    }

}

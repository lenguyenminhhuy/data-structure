package com.week1;

import java.util.ArrayList;
import java.util.Arrays;

public class question1 {
    public static int findSecondLargestNumber(int[] arr){
        int largestNumber = 0;
        int secondLargestNumber = 0;
        for (int j : arr) {
            if (largestNumber < j) {
                secondLargestNumber = largestNumber;
                largestNumber = j;
            } else {
                if (secondLargestNumber < j) {
                    secondLargestNumber = j;
                }
            }
        }
        return secondLargestNumber;
    }

    public static void main(String[] args){
        int[] array = { 1,5,3,6,4 };
        int result = findSecondLargestNumber(array);
        System.out.println("Array: " + Arrays.toString(array));
        System.out.println("Second largest: " + result);

        }


}

package com.week1;

import java.util.Arrays;

public class question2 {
    // find the missing value number
    public static void main(String[] args){
        int[] arr = new int[100];
        for (int i=0; i<arr.length; i++){
            arr[i] = i;
            if (i == 32){
                i ++;
            }
        }
        int n = 100*99/2;
        int sumArr = 0;
        for (int i: arr){
            sumArr += arr[i];
        }
        System.out.println("Missing number is: " + (n-sumArr));
    }

}

package com.week2;

import java.util.Arrays;
import java.util.HashSet;

public class Question3 {
    public static void findUniqueNumber(int[] arr){
        HashSet<Integer> numbers = new HashSet<>();
        for (int i = 0; i<arr.length; i++){
            if (!numbers.contains(arr[i])){
                numbers.add(arr[i]);
                System.out.println(arr[i]);
            }
        }
    }
    public static void main(String[] args){
        int[] set = {1, 2, 7, 4, 4, 2, 6, 7, 6};
        findUniqueNumber(set);
    }

}

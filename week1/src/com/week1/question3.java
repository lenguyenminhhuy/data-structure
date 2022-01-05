package com.week1;

public class question3 {
    // check whether an array contains consecutive numbers
    public static boolean isConsecutive(int[] arr){
        int minNumber = arr[0];
        int maxNumber = arr[0];
        for (int i=0; i<arr.length; i++){
            if (minNumber > arr[i]){
                minNumber = arr[i];
            }
            if (maxNumber < arr[i]){
                maxNumber = arr[i];
            }
        }
        return maxNumber - minNumber < arr.length;
    }
    public static void main(String[] args){
        int[] array = {46, 45, 43, 44, 48};
        boolean result = isConsecutive(array);
        System.out.println("The given array contain consecutive numbers: " + result);
    }
}

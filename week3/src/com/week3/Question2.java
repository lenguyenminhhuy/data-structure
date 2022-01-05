package com.week3;

public class Question2 {
    int findMaximumIncrease(int[] arr) {
        int max = 0;
        int min = 99999;
        int maxIndex = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > max){
                max = arr[i];
                maxIndex = i;
            }
        }
        for (int i = 0; i <= maxIndex; i++){
            if (arr[i] < min){
                min = arr[i];
            }
        }
        return max - min;
    }
    public static void main(String[] args) {
        Question2 q = new Question2();
        int[] arr = {14, 12, 70, 15, 95, 65, 22, 99, 8};
        System.out.println(q.findMaximumIncrease(arr));
    }
}

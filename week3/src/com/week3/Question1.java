package com.week3;

public class Question1 {
    int searchValue(int[] arr, int value) {
        int i=0;
        int j=arr.length-1;
        int mid = (i+j)/2;
        while(i<=j){
            mid = (i+j)/2;
            if(arr[mid]== value){
                return mid;
            }else if(arr[mid]>value){
                j=mid-1;
            }else{
                i=mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Question1 q1 = new Question1();
        int[] arr = {-1,0,1,2,3,4,5,6,7,8,9,10};
        System.out.println(q1.searchValue(arr, 8));
    }
}

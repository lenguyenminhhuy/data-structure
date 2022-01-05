package com.week2;

public class BinarySearch {
    public int binarySearch(int[] array, int target){
        int left = 0;
        int right = array.length-1;
        while (left<=right){
            int mid = left + (int)(right-left)/2;
            if (array[mid] == target){
                return mid;
            }
            else if(array[mid] < target){
                left = mid + 1;
            }
            right = mid + 1;
        }
        return left;
    }
    public static void main(String[] args){
        int[] array = {1,2,4,10,11};
        int target = 11;
        BinarySearch ob = new BinarySearch();
        System.out.println(ob.binarySearch(array, target));

    }
}

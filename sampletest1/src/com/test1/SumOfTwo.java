package com.test1;

public class SumOfTwo {
    public boolean checkPair(int[] A, int S){
        int left =0;
        int right = A.length -1;
        // since left must be different from right
        while (left < right){
            if (A[left] + A[right] == S){
                return true;
            }
            else if (A[left] + A[right] > S){
                right--;
            }
            else if (A[left] + A[right] < S){
                left++;
            }
        }
        return false;
    }
    public static void main(String[] args){
        SumOfTwo sum = new SumOfTwo();
        int[] testArr = {1,2,5,6,9,11};
        System.out.println(sum.checkPair(testArr, 22));
    }
}

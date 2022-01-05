package com.week1;

public class question4 {
    public static int  findMaxStep(int[] arr){
        int[] frequencies = new int[arr.length];
        int maxFreq = frequencies[0];
        for (int i=0; i<arr.length; i++ ){
            int number = i;
            int step = 0;
            System.out.println(number);
            while (number > 1){
                if (frequencies[number] > 0){
                    frequencies[number] = frequencies[i] + step;
                    break;
                }

                if (number%2 == 0){
                    number = number/ 2;
                }
                else {
                    number = 3*number + 1;
                }

                step += 1;

                if(frequencies[number] == 0 ){
                    frequencies[number] = step;
                }
            }

            if (maxFreq < frequencies[i]){
                maxFreq = frequencies[i];
            }
        }
        return maxFreq;
    }
    public static void main(String[] args){
        int[] array = new int[100];
        System.out.println(findMaxStep(array));
    }
}

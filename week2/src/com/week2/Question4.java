package com.week2;

import java.util.Arrays;

public class Question4 {
    public static int findGate(int[] arrival, int[] departure){
        Arrays.sort(arrival);
        Arrays.sort(departure);
        int result = 1;
        int currentGate = 1;
        int i = 1;
        int j = 0;
        while (i < arrival.length && j < departure.length){
            if(arrival[i] < departure[j]){
                currentGate ++;
                i++;
            }
            else if(arrival[i] > departure[j]){
                currentGate--;
                j++;
            }
            result = Math.max(result, currentGate);
        }
        return result;
    }

    // driver
    public static void main(String[] args){
        int[] arrival = {100, 140, 150, 200, 215, 400};
        int[] departure = {110, 300, 220, 230, 315, 600};
        System.out.println(findGate(arrival, departure));
    }
}

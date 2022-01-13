package com.week11;

import java.util.ArrayList;

public class Knapsack {

    static int Knapsack(Item[] items, int capacity){
        int n = items.length;
        int[][] V = new int[n+1][capacity+1];
        boolean[][] taken = new boolean[n+1][capacity+1];

        // initialize V table
        for (int i=0; i <= n; i++){
            for (int j = 0; j <= capacity; j++){
                V[i][j] = 0;
            }
        }

        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= capacity; j++){
                // if this item is too heavy to put in the knapsack, we do not put it into the V table
                if (items[i-1].weight > j){
                    V[i][j] = V[i-1][j];
                    continue;
                }

                // then add the item the knapsack if it can increase the total value
                if (V[i-1][j-items[i-1].weight] + items[i-1].val > V[i-1][j]){
                    V[i][j] = V[i-1][j-items[i-1].weight] + items[i-1].val;
                    // mark as taken
                    taken[i][j] = true;
                } else {
                    V[i-1][j] = V[i][j];
                }
            }
        }

        // display the items
        ArrayList<Integer> result = new ArrayList<>();
        int cap = capacity;
        int NB_ITEMS = n;
        while (NB_ITEMS > 0 && cap > 0) {
            if (taken[NB_ITEMS][cap]){
                result.add(NB_ITEMS-1);
                cap -= items[NB_ITEMS-1].weight;
            }
            NB_ITEMS--;
        }

        System.out.println("Items selected:");
        for (int res : result) {
            System.out.printf("(w: %d, v: %d) ", items[res].weight, items[res].val);
        }
        System.out.println("\n--------------");

        return V[NB_ITEMS][cap];
    }
    public static void main(String args[]){
        Item i1 = new Item(3, 55);
        Item i2 = new Item(2, 20);
        Item i3 = new Item(1, 15);
        Item i4 = new Item(4, 40);
        Item i5 = new Item(5, 50);
        System.out.println(Knapsack(new Item[] {i1, i2, i3, i4, i5}, 5));
    }
}

class Item {
    int weight;
    int val;
    public Item(int w, int v){
        this.weight = w;
        this.val = v;
    }
}
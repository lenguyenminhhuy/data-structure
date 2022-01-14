package com.finaltest;

import java.util.ArrayList;

public class RoadSystem {
    ArrayList<Lab> labCollections;
    public RoadSystem() {
        labCollections = new ArrayList<Lab>();
    }

    public void addLab(Lab l){
        labCollections.add(l);
    }

    public double simpleLength(){
        double length = 0;
        int i = 0;
        int j = 1;
        while(i < labCollections.size() && j < labCollections.size()){
            Lab a = labCollections.get(i);
            Lab b = labCollections.get(j);
            length += Math.sqrt((a.x - b.x)*(a.x - b.x) + (a.y - b.y)*(a.y - b.y));
            i++;
            j++;
        }
        System.out.println(length);
        return length;
    }

    public double optimalLength(){
        double[][] distances = new double[labCollections.size()][labCollections.size()];
        double length = 0;

        for (int i = 0; i<labCollections.size(); i++){
            for (int j = 0; j<labCollections.size(); j++){
                if (i == j){
                    distances[i][j] = 0;
                }
                else{
                    Lab a = labCollections.get(i);
                    Lab b = labCollections.get(j);
                    length += Math.sqrt((a.x - b.x)*(a.x - b.x) + (a.y - b.y)*(a.y - b.y));
                    distances[i][j] = length;
                }
            }
        }
        // checking purpose
//        for (int m = 0; m < distances.length; m++) {
//            for (int n = 0; n < distances.length; n++) {
//                System.out.print(distances[m][n] + " ");
//            }
//        }

        int n = distances.length;
        // create an array to store the minimum distance from src to each point
        int[] minimumDistances = new int[n];

        for (int i = 0; i < n; i++){
            minimumDistances[i] = Integer.MAX_VALUE;
        }
        minimumDistances[0] = 0;

        boolean[]  visited = new boolean[n];
        visited[0] = true;

        int currentPoint = 0;
        while (true){
            // start updating the shortest path to all un-visited ndoes
            for (int i = 0; i < n; i++){
                if (visited[i]){
                    continue;
                }
                if (distances[currentPoint][i] > 0){
                    if (minimumDistances[currentPoint] + distances[currentPoint][i] < minimumDistances[i]){
                        minimumDistances[i] = (int)(minimumDistances[currentPoint] + distances[currentPoint][i]);
                    }
                }
            }
            int shortestLength = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++){
                if (visited[i]){
                    continue;
                }
                if (shortestLength > minimumDistances[i]){
                    shortestLength = minimumDistances[i];
                    currentPoint = i;
                }
            }
            if (currentPoint == n-1){
                System.out.println(minimumDistances[n-1]);
                return minimumDistances[n-1];
            }

            visited[currentPoint] = true;
        }
    }

    public static void main(String args[]){
        Lab l1 = new Lab("Advanced AI", 0.0, 0.0);
        Lab l2 = new Lab("Cyber Security", 10, 0);
        Lab l3 = new Lab("IoT", 0, 10);
        RoadSystem rs = new RoadSystem();
        rs.addLab(l1);
        rs.addLab(l2);
        rs.addLab(l3);
        rs.simpleLength();  // return 24.142
        rs.optimalLength();  // return 20

    }
}

class Lab {
    String name;
    double x;
    double y;
    public Lab(String name, double x, double y){
        this.name = name;
        this.x = x;
        this.y = y;
    }
}

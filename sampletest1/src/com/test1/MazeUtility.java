package com.test1;

public class MazeUtility {
    private int rows;
    private int cols;
    private char startPoint;
    private char endPoint;
    private char[][] maze;

    public MazeUtility(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
    }
    // display maze
    public void displayMaze(char[][] maze) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int countEnd(char[][] maze){
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (maze[i][j] == 'E') {
                    count++;
                }
            }
        }
        return count;
    }

    // solve the maze
//    public boolean solvable(char[][] maze) {
//        // 1st case
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                if (maze[i][j] == 'E') {
//                    continue;
//                    return true;
//                }
//            }
//        }
//    }


    public static void main(String[] args) {
        int rows = 10;
        int cols = 10;
        MazeUtility maze = new MazeUtility(rows, cols);
        char[][] maze1 = new char[rows][cols];
        maze1[0][0] = 'S';
        maze1[rows - 1][cols - 1] = 'E';
        for (int i = 0; i < rows; i++) {
            for (int j =0; j < cols; j++){
                if (i==0 && j==0 || i == rows - 1 && j == cols - 1) {
                    continue;
                }
                else {
                    maze1[i][j] = '.';
                }
            }
        }
        maze.displayMaze(maze1);
        System.out.println(maze.countEnd(maze1));
    }
}

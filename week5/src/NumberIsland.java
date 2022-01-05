// [1,1,1,0,0
//  0,1,0,0,0
//  1,1,1,0,0]
public class NumberIsland {
    public int countNumberIsland(char[][] grid){
        int count = 0;
        for (int i = 0; i<grid.length; i++){
            for (int j =0; j<grid[0].length; j++){
                if (grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int i, int j){
        if (i <0 || i>=grid.length || j<0 || j>= grid[i].length ||grid[i][j] == '0') {
        return;
        }
        grid[i][j] = '0'; // when detect a '1', we mark it as '0' so we don't visit again
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }
}

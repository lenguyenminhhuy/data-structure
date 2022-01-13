package dynamicprogramming;

public class LongestCommonSubsequence {

    public static char[] lcs(char[] a, char[] b){
        int res = 0;
        int rows = a.length;
        int cols = b.length;
        int[][] dp = new int[rows+1][cols+1];

        if (rows == 0 || cols == 0){
            return null;
        }

        for (int i = 1; i <= rows; i++){
            for (int j = 1; j <= cols; j++){
                if (a[i-1] == b[j-1]){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        // build the solution
        int longestLength = dp[rows][cols];
        char[] longestSequence = new char[longestLength];
        int i = rows;
        int j = cols;
        while (i >= 1 && j >= 1){
            if (a[i-1] == b[j-1]){
                longestSequence[longestLength-1] = a[i-1];
                i--;
                j--;
                longestLength--;
            }
            else if (dp[i-1][j] > dp[i][j-1]){
                i--;
            } else{
                j--;
            }
        }
        return longestSequence;
    }

    public static void main(String args[]){
        char[] A = {'A', 'B', 'C', 'D', 'H'};
        char[] B = {'A', 'C', 'H'};
        System.out.println(lcs(A, B));
    }
}

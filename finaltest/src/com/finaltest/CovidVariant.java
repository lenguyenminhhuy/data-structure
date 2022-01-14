package com.finaltest;

public class CovidVariant {
    String code;
    String sequence;

    public CovidVariant(String code, String sequence){
        this.code = code;
        this.sequence = sequence;
    }

    public boolean evenSequence(){
        if (this.sequence.length() % 2 == 0){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isSubsequence(String s){
        int curIdx = 0;
        int sIdx = 0;
        while (curIdx < this.sequence.length() && sIdx < s.length()){
            if (this.sequence.charAt(curIdx) == s.charAt(sIdx)){
                sIdx++;
            }
            curIdx++;
        }
        return sIdx == s.length();
    }

    public int longestCommonSubsequence(CovidVariant other){
        int rows = this.sequence.length();
        int cols = other.sequence.length();
        int[][] dp = new int[rows+1][cols+1];
        // if one of them is null -> there is no common subsequence -> return 0
        if (rows == 0 || cols == 0){
            return 0;
        }

        for (int i = 1; i<=rows; i++){
            for (int j = 1; j <= cols; j++){
                if (this.sequence.charAt(i-1) == other.sequence.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[rows][cols]);
        return dp[rows][cols];
    }
    public static void main(String args[]){
        CovidVariant v1 = new CovidVariant("DELTA", "HELLOFROMDELTA");
        System.out.println(v1.evenSequence());  // return true
        System.out.println(v1.isSubsequence("HLOFRDLA")); // return true
        CovidVariant v2 = new CovidVariant("BETA", "HELLOFROMBETA");
        System.out.println(v2.evenSequence()); // return false
        System.out.println(v2.isSubsequence("HLOFRDLA")); // return false
        v1.longestCommonSubsequence(v2);  // return 12, the longest common subsequence is "HELLOFROMETA"
    }
}

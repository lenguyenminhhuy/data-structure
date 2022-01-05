package dynamicprogramming;

public class LongestSubstringPalindrome {
    public String findLongestSubstringPalindrome(String s){
        String result = "";

        // initialize 2 variable to keep track index of new substring
        int start =0, end = 0;
        for (int i = 0; i<s.length(); i++){
            int lenOddCase = findLengthOfCurrentPalindrome(s, i, i);
            int lenEvenCase = findLengthOfCurrentPalindrome(s, i, i+1);
            int finalLen = Math.max(lenOddCase, lenEvenCase);
            if (finalLen > end - start){
                start = i - (finalLen-1)/2;
                end = i + (finalLen/2);
            }
        }
        result = s.substring(start, end+1);
        return result;
    }
    private int findLengthOfCurrentPalindrome(String s, int left, int right){
        int curLen = 0;
        if (s == null || left > right){
            return 0;
        }

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        curLen = right - left - 1;
        return curLen;
    }

    public static void main(String[] args){
        LongestSubstringPalindrome res = new LongestSubstringPalindrome();
        String s1 = res.findLongestSubstringPalindrome("aaaabba");
        String s2 = res.findLongestSubstringPalindrome("hiracecarhi");
        System.out.println(s1.toString());
        System.out.println(s2.toString());
    }
}

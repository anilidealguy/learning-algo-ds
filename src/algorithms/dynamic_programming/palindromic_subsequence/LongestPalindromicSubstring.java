package algorithms.dynamic_programming.palindromic_subsequence;

public class LongestPalindromicSubstring {
    public int findLPSLengthMemoization(String st) {
        return findLPSLengthMemoization(st.toCharArray(), new Integer[st.length()][st.length()],0, st.length()-1);
    }

    private int findLPSLengthMemoization(char[] st, Integer[][] memo, int startIndex, int endIndex) {
        if (startIndex > endIndex)
            return 0;

        if (startIndex == endIndex)
            return 1;

        if (memo[startIndex][endIndex] != null)
            return memo[startIndex][endIndex];

        if (st[startIndex] == st[endIndex]) {
            int res = findLPSLengthMemoization(st, memo, startIndex + 1, endIndex - 1);
            if (res == endIndex - startIndex - 1) {
                memo[startIndex][endIndex] = 2 + res;
                return memo[startIndex][endIndex];
            }
        }

        memo[startIndex][endIndex] = Math.max(findLPSLengthMemoization(st, memo, startIndex, endIndex - 1), findLPSLengthMemoization(st, memo, startIndex + 1, endIndex));
        return memo[startIndex][endIndex];
    }

    public int findLPSLengthRecursive(String st) {
        return findLPSLengthRecursive(st.toCharArray(), 0, st.length()-1);
    }

    private int findLPSLengthRecursive(char[] st, int startIndex, int endIndex) {
        if (startIndex > endIndex)
            return 0;

        if (startIndex == endIndex)
            return 1;

        if (st[startIndex] == st[endIndex]) {
            int res = findLPSLengthRecursive(st, startIndex + 1, endIndex - 1);
            if (res == endIndex - startIndex - 1)
                return  2 + res;
        }

        return Math.max(findLPSLengthRecursive(st, startIndex, endIndex-1), findLPSLengthRecursive(st, startIndex+1, endIndex));
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        System.out.println(lps.findLPSLengthRecursive("abdbca"));
        System.out.println(lps.findLPSLengthRecursive("cddpd"));
        System.out.println(lps.findLPSLengthRecursive("pqr"));

        System.out.println(lps.findLPSLengthMemoization("abdbca"));
        System.out.println(lps.findLPSLengthMemoization("cddpd"));
        System.out.println(lps.findLPSLengthMemoization("pqr"));
    }
}

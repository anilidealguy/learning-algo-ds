package algorithms.dynamic_programming.palindromic_subsequence;

public class LongestPalindromicSubsequence {
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
            memo[startIndex][endIndex] = 2 + findLPSLengthMemoization(st, memo, startIndex + 1, endIndex - 1);
            return memo[startIndex][endIndex];
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

        if (st[startIndex] == st[endIndex])
            return 2 + findLPSLengthRecursive(st, startIndex+1, endIndex-1);

        return Math.max(findLPSLengthRecursive(st, startIndex, endIndex-1), findLPSLengthRecursive(st, startIndex+1, endIndex));
    }

    public static void main(String[] args) {
        LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
        System.out.println(lps.findLPSLengthRecursive("abdbca"));
        System.out.println(lps.findLPSLengthRecursive("cddpd"));
        System.out.println(lps.findLPSLengthRecursive("pqr"));

        System.out.println(lps.findLPSLengthMemoization("abdbca"));
        System.out.println(lps.findLPSLengthMemoization("cddpd"));
        System.out.println(lps.findLPSLengthMemoization("pqr"));
    }
}

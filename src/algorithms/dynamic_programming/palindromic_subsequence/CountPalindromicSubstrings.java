package algorithms.dynamic_programming.palindromic_subsequence;

public class CountPalindromicSubstrings {
    public int findCPSMemoization(String st) {
        return findCPSMemoization(st.toCharArray(), new Integer[st.length()][st.length()],0, st.length()-1);
    }

    private int findCPSMemoization(char[] st, Integer[][] memo, int startIndex, int endIndex) {
        if (startIndex > endIndex)
            return 0;

        if (memo[startIndex][endIndex] != null)
            return memo[startIndex][endIndex];

        if (startIndex == endIndex) {
            memo[startIndex][endIndex] = 1;
            return memo[startIndex][endIndex];
        }

        int res = 0;
        if (isPalindrome(st, startIndex, endIndex))
            res = 1;

        res += findCPSMemoization(st, memo, startIndex + 1, endIndex)
                + findCPSMemoization(st, memo, startIndex, endIndex - 1)
                - findCPSMemoization(st, memo, startIndex + 1, endIndex - 1);

        memo[startIndex][endIndex] = res;
        return memo[startIndex][endIndex];
    }

    private boolean isPalindrome(char[] st, int startIndex, int endIndex) {
        while(startIndex <= endIndex) {
            if(st[startIndex++] != st[endIndex--])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        CountPalindromicSubstrings cps = new CountPalindromicSubstrings();
        System.out.println(cps.findCPSMemoization("abdbca"));
        System.out.println(cps.findCPSMemoization("cdpdd"));
        System.out.println(cps.findCPSMemoization("pqr"));
    }
}

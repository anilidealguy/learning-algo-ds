package algorithms.dynamic_programming.palindromic_subsequence;

public class MinimumDeletionsToMakePalindrome {
    private int findMinimumDeletions(String st) {
        // Minimum Deletions to make a string palindrome = length(given string) - longest palindromic subsequence
        LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
        return st.length() - lps.findLPSLengthMemoization(st);
    }

    public static void main(String[] args) {
        MinimumDeletionsToMakePalindrome mdsp = new MinimumDeletionsToMakePalindrome();
        System.out.println(mdsp.findMinimumDeletions("abdbca"));
        System.out.println(mdsp.findMinimumDeletions("cddpd"));
        System.out.println(mdsp.findMinimumDeletions("pqr"));
    }
}

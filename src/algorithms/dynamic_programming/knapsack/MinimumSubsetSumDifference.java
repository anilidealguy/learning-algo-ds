package algorithms.dynamic_programming.knapsack;

import java.util.Arrays;

public class MinimumSubsetSumDifference {

    public int canPartitionMemoization(int[] num) {
        int sum = Arrays.stream(num).sum();
        return this.canPartitionMemoization(num, new Integer[num.length][sum+1], num.length-1, 0, 0);
    }

    private int canPartitionMemoization(int[] num, Integer[][] memo, int currentIndex, int sum1, int sum2) {
        if (currentIndex < 0 )
            return Math.abs(sum1 - sum2);

        if (memo[currentIndex][sum1] != null)
            return memo[currentIndex][sum1];

        int diff1 = canPartitionMemoization(num, memo, currentIndex-1, sum1+num[currentIndex], sum2);
        int diff2 = canPartitionMemoization(num, memo, currentIndex-1, sum1, sum2+num[currentIndex]);

        int currMin = Math.min(diff1, diff2);

        memo[currentIndex][sum1] = currMin;

        return currMin;
    }

    public int canPartitionRecursive(int[] num) {
        return this.canPartitionRecursive(num, num.length-1, 0, 0);
    }

    private int canPartitionRecursive(int[] num, int currentIndex, int sum1, int sum2) {
        if (currentIndex < 0 )
            return Math.abs(sum1 - sum2);

        int diff1 = canPartitionRecursive(num, currentIndex - 1, sum1+num[currentIndex], sum2);
        int diff2 = canPartitionRecursive(num, currentIndex - 1, sum1, sum2+num[currentIndex]);

        return Math.min(diff1, diff2);
    }

    public static void main(String[] args) {
        MinimumSubsetSumDifference ps = new MinimumSubsetSumDifference();
        int[] num = {1, 2, 3, 9};
        System.out.println(ps.canPartitionRecursive(num));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ps.canPartitionRecursive(num));
        num = new int[]{1, 3, 100, 4};
        System.out.println(ps.canPartitionRecursive(num));


        num = new int[]{1, 2, 3, 9};
        System.out.println(ps.canPartitionMemoization(num));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ps.canPartitionMemoization(num));
        num = new int[]{1, 3, 100, 4};
        System.out.println(ps.canPartitionMemoization(num));
    }
}

package algorithms.dynamic_programming.knapsack;

import java.util.Arrays;

public class SubsetSum {
    public boolean canPartitionMemoization(int[] num, int sum) {
        return canPartitionMemoization(num, sum, num.length-1, new Boolean[num.length][sum + 1]);
    }

    private boolean canPartitionMemoization(int[] num, int sum, int i, Boolean[][] memo){
        if (sum == 0)
            return true;

        if (sum < 0 || i < 0)
            return false;

        if (memo[i][sum] != null)
            return memo[i][sum];

        boolean pick = false;
        if (num[i] <= sum)
            pick = canPartitionMemoization(num, sum - num[i], i-1, memo);

        boolean unPick = canPartitionMemoization(num, sum, i-1, memo);

        boolean isPossible = pick || unPick;
        memo[i][sum] = isPossible;
        return isPossible;
    }

    public boolean canPartitionRecursive(int[] num, int sum) {
        return canPartitionRecursive(num, sum, num.length-1);
    }

    private boolean canPartitionRecursive(int[] num, int sum, int i){
        if (sum == 0)
            return true;

        if (sum < 0 || i < 0)
            return false;

        boolean pick = false;
        if (num[i] <= sum)
            pick = canPartitionRecursive(num, sum - num[i], i-1);

        boolean unPick = canPartitionRecursive(num, sum, i-1);

        return pick || unPick;
    }

    public static void main(String[] args) {
        SubsetSum ps = new SubsetSum();
        int[] num = {1, 2, 3, 4};
        System.out.println(ps.canPartitionRecursive(num, Arrays.stream(num).sum()/2));
        num = new int[]{1, 1, 3, 4, 7};
        System.out.println(ps.canPartitionRecursive(num, Arrays.stream(num).sum()/2));
        num = new int[]{2, 3, 4, 6};
        System.out.println(ps.canPartitionRecursive(num, 1));

        num = new int[]{1, 2, 3, 4};
        System.out.println(ps.canPartitionMemoization(num, Arrays.stream(num).sum()/2));
        num = new int[]{1, 1, 3, 4, 7};
        System.out.println(ps.canPartitionMemoization(num, Arrays.stream(num).sum()/2));
        num = new int[]{2, 3, 4, 6};
        System.out.println(ps.canPartitionMemoization(num, 1));
    }
}

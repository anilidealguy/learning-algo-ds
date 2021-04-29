package algorithms.dynamic_programming.knapsack;

public class CountOfSubsetSum {
    public int countSubsetsMemoization(int[] num, int sum) {
        return countSubsetsMemoization(num, new Integer[num.length][sum+1], sum, num.length-1);
    }

    private int countSubsetsMemoization(int[] num, Integer[][] memo, int sum, int i) {
        if (i < 0 && sum != 0)
            return 0;

        if (sum == 0)
            return 1;

        if (memo[i][sum] != null)
            return memo[i][sum];

        int pick = 0;
        if (num[i] <= sum)
            pick = countSubsetsMemoization(num, memo, sum-num[i], i-1);

        int unPick = countSubsetsMemoization(num, memo, sum, i-1);

        memo[i][sum] = pick + unPick;
        return memo[i][sum];
    }

    public int countSubsetsRecursive(int[] num, int sum) {
        return countSubsetsRecursive(num, sum, num.length-1);
    }

    private int countSubsetsRecursive(int[] num, int sum, int i) {
        if (i < 0 && sum != 0)
            return 0;

        if (sum == 0)
            return 1;

        int pick = 0;
        if (num[i] <= sum)
            pick = countSubsetsRecursive(num, sum-num[i], i-1);

        int unPick = countSubsetsRecursive(num, sum, i-1);

        return pick + unPick;
    }

    public static void main(String[] args) {
        CountOfSubsetSum ss = new CountOfSubsetSum();
        int[] num = {1, 1, 2, 3};
        System.out.println(ss.countSubsetsRecursive(num, 4));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ss.countSubsetsRecursive(num, 9));

        num = new int[]{1, 1, 2, 3};
        System.out.println(ss.countSubsetsMemoization(num, 4));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ss.countSubsetsMemoization(num, 9));
    }
}

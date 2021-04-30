package algorithms.dynamic_programming.unbounded_knapsack;

public class CoinChange {
    public int countChangeDynamicProgramming(int[] denominations, int total) {
        int length = denominations.length;
        int[][] dp = new int[length][total+1];

        // When total is 0 we can get it in one way that is by not selecting anything
        for (int i = 0; i < length; i++)
            dp[i][0] = 1;

        for (int i = 0; i < length; i++) {
            for (int j = 1; j <= total; j++) {
                if (i > 0)
                    dp[i][j] = dp[i-1][j];

                if (denominations[i] <= j)
                    dp[i][j] += dp[i][j - denominations[i]];
            }
        }

        return dp[length-1][total];
    }


    public int countChangeMemoization(int[] denominations, int total) {
        return countChangeMemoization(denominations, total, new Integer[denominations.length][total+1],denominations.length-1);
    }

    private int countChangeMemoization(int[] denominations, int total, Integer[][] memo,int i) {
        if (total < 0 || i < 0)
            return 0;

        if (total == 0)
            return 1;

        if (memo[i][total] != null)
            return memo[i][total];

        int pick = 0;
        if (denominations[i] <= total)
            pick = countChangeMemoization(denominations, total - denominations[i], memo, i);

        int unPick = countChangeMemoization(denominations, total, memo, i-1);

        memo[i][total] = pick + unPick;
        return memo[i][total];
    }

    public int countChangeRecursive(int[] denominations, int total) {
        return countChangeRecursive(denominations, total, denominations.length-1);
    }

    private int countChangeRecursive(int[] denominations, int total, int i) {
        if (total < 0 || i < 0)
            return 0;

        if (total == 0)
            return 1;

        int pick = 0;
        if (denominations[i] <= total)
            pick = countChangeRecursive(denominations, total - denominations[i], i);

        int unPick = countChangeRecursive(denominations, total, i-1);

        return pick + unPick;
    }

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        int[] denominations = {1, 2, 3};
        System.out.println(cc.countChangeRecursive(denominations, 5));

        denominations = new int[]{1, 2, 3};
        System.out.println(cc.countChangeMemoization(denominations, 5));

        denominations = new int[]{1, 2, 3};
        System.out.println(cc.countChangeDynamicProgramming(denominations, 5));
    }
}

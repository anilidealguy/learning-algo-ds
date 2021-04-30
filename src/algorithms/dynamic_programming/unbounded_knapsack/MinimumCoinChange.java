package algorithms.dynamic_programming.unbounded_knapsack;

public class MinimumCoinChange {
    public int countChangeMemoization(int[] denominations, int total) {
        int res = countChangeMemoization(denominations, new Integer[denominations.length][total+1], total,denominations.length - 1);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int countChangeMemoization(int[] denominations, Integer[][] memo, int total, int i) {
        if (total < 0 || i < 0)
            return Integer.MAX_VALUE;

        if (total == 0)
            return 0;

        if (memo[i][total] != null)
            return memo[i][total];

        int pick = Integer.MAX_VALUE;
        if (denominations[i] <= total) {
            pick = countChangeMemoization(denominations, memo, total - denominations[i], i);
            if (pick != Integer.MAX_VALUE)
                pick++;
        }

        int unPick = countChangeMemoization(denominations, memo, total, i-1);

        int res = Math.min(pick, unPick);
        memo[i][total] = res;
        return res;
    }


    public int countChangeRecursive(int[] denominations, int total) {
        int res = countChangeRecursive(denominations, total, denominations.length - 1);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int countChangeRecursive(int[] denominations, int total, int i) {
        if (total < 0 || i < 0)
            return Integer.MAX_VALUE;

        if (total == 0)
            return 0;

        int pick = Integer.MAX_VALUE;
        if (denominations[i] <= total) {
            pick = countChangeRecursive(denominations, total - denominations[i], i);
            if (pick != Integer.MAX_VALUE)
                pick++;
        }

        int unPick = countChangeRecursive(denominations, total, i-1);

        return Math.min(pick, unPick);
    }

    public static void main(String[] args) {
        MinimumCoinChange cc = new MinimumCoinChange();
        int[] denominations = {1, 2, 3};
        System.out.println(cc.countChangeRecursive(denominations, 5));
        System.out.println(cc.countChangeRecursive(denominations, 11));
        System.out.println(cc.countChangeRecursive(denominations, 7));
        denominations = new int[]{3, 5};
        System.out.println(cc.countChangeRecursive(denominations, 7));

        denominations = new int[]{1, 2, 3};
        System.out.println(cc.countChangeMemoization(denominations, 5));
        System.out.println(cc.countChangeMemoization(denominations, 11));
        System.out.println(cc.countChangeMemoization(denominations, 7));
        denominations = new int[]{3, 5};
        System.out.println(cc.countChangeMemoization(denominations, 7));
    }
}

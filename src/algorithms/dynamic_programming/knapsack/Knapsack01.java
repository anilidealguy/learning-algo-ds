package algorithms.dynamic_programming.knapsack;

import java.util.Arrays;

public class Knapsack01 {
    public int solveKnapsackDP(int[] profits, int[] weights, int capacity) {
        int n = profits.length;
        int[][] dp = new int[n][capacity + 1];

        for (int i = 0; i < n; i++)
            dp[i][0] = 0;

        for(int c=0; c <= capacity; c++) {
            if(weights[0] <= c)
                dp[0][c] = profits[0];
        }

        int pick;
        int unPick;
        for (int i = 1; i < n; i++) {
            for (int c = 1; c <= capacity; c++) {
                pick = 0;
                if (weights[i] <= c)
                    pick = profits[i] + dp[i-1][c - weights[i]];

                unPick = dp[i-1][c];
                dp[i][c] = Math.max(pick, unPick);
            }
        }

        return dp[n -1][capacity];
    }

    public int solveKnapsackMemoization(int[] profits, int[] weights, int capacity) {
        int[][] memo = new int[profits.length][capacity + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return solveKnapsackMemoization(profits, weights, profits.length - 1, capacity, memo);
    }

    private int solveKnapsackMemoization(int[] profits, int[] weights, int i, int capacity, int[][] memo) {
        if (capacity <= 0 || i < 0)
            return 0;

        if (memo[i][capacity] != -1)
            return memo[i][capacity];

        int pick = 0;
        int unPick = solveKnapsackMemoization(profits, weights, i - 1, capacity, memo);

        if (weights[i] <= capacity)
            pick = solveKnapsackMemoization(profits, weights, i - 1, capacity - weights[i], memo) + profits[i];

        int currentProfit = Math.max(pick, unPick);

        memo[i][capacity] = currentProfit;
        return currentProfit;
    }

    public int solveKnapsackRecursive(int[] profits, int[] weights, int capacity) {
        return solveKnapsackRecursive(profits, weights, profits.length - 1, capacity);
    }

    private int solveKnapsackRecursive(int[] profits, int[] weights, int i, int capacity) {
        if (capacity <= 0 || i < 0)
            return 0;

        int pick = 0;
        int unPick = solveKnapsackRecursive(profits, weights, i - 1, capacity);

        if (weights[i] <= capacity)
            pick = solveKnapsackRecursive(profits, weights, i - 1, capacity - weights[i]) + profits[i];

        return Math.max( pick, unPick );
    }

    public static void main(String[] args) {
        Knapsack01 ks = new Knapsack01();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsackRecursive(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsackRecursive(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);

        maxProfit = ks.solveKnapsackMemoization(profits, weights, 7);
        System.out.println("Total knapsack profit Memoization ---> " + maxProfit);

        maxProfit = ks.solveKnapsackMemoization(profits, weights, 6);
        System.out.println("Total knapsack profit Memoization ---> " + maxProfit);

        maxProfit = ks.solveKnapsackDP(profits, weights, 7);
        System.out.println("Total knapsack profit DP ---> " + maxProfit);

        maxProfit = ks.solveKnapsackDP(profits, weights, 6);
        System.out.println("Total knapsack profit DP ---> " + maxProfit);
    }
}

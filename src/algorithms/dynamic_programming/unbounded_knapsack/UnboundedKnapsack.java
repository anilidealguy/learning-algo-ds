package algorithms.dynamic_programming.unbounded_knapsack;

public class UnboundedKnapsack {
    public int solveKnapsackMemoization(int[] profits, int[] weights, int capacity) {
        return solveKnapsackMemoization(profits, weights, new Integer[profits.length][capacity+1], capacity, profits.length-1);
    }

    public int solveKnapsackMemoization(int[] profits, int[] weights, Integer[][] memo, int capacity, int i) {
        if (i < 0 || capacity <= 0)
            return 0;

        if (memo[i][capacity] != null)
            return memo[i][capacity];

        int pick = 0;
        if (weights[i] <= capacity)
            pick = solveKnapsackMemoization(profits, weights, memo, capacity-weights[i], i) + profits[i];

        int unPick = solveKnapsackMemoization(profits, weights, memo, capacity, i-1);
        int currentMax = Math.max(pick, unPick);
        memo[i][capacity] = currentMax;

        return currentMax;
    }


    public int solveKnapsackRecursive(int[] profits, int[] weights, int capacity) {
        return solveKnapsackRecursive(profits, weights, capacity, profits.length-1);
    }

    public int solveKnapsackRecursive(int[] profits, int[] weights, int capacity, int i) {
        if (i < 0 || capacity <= 0)
            return 0;

        int pick = 0;
        if (weights[i] <= capacity)
            pick = solveKnapsackRecursive(profits, weights, capacity-weights[i], i) + profits[i];

        int unPick = solveKnapsackRecursive(profits, weights, capacity, i-1);
        return Math.max(pick, unPick);
    }

    public static void main(String[] args) {
        UnboundedKnapsack ks = new UnboundedKnapsack();
        int[] profits = { 15, 50, 60, 90 };
        int[] weights = { 1, 3, 4, 5 };
        int maxProfit = ks.solveKnapsackRecursive(profits, weights, 8);
        System.out.println(maxProfit);

        profits = new int[]{ 15, 50, 60, 90 };
        weights = new int[]{ 1, 3, 4, 5 };
        maxProfit = ks.solveKnapsackMemoization(profits, weights, 8);
        System.out.println(maxProfit);
    }
}

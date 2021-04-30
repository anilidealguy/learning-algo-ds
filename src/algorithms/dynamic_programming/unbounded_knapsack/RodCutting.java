package algorithms.dynamic_programming.unbounded_knapsack;

public class RodCutting {
    public int solveRodCutting(int[] lengths, int[] prices, int n) {
        UnboundedKnapsack uks = new UnboundedKnapsack();
        return uks.solveKnapsackMemoization(prices, lengths, n);
    }

    public static void main(String[] args) {
        RodCutting rc = new RodCutting();
        int[] lengths = {1, 2, 3, 4, 5};
        int[] prices = {2, 6, 7, 10, 13};
        int maxProfit = rc.solveRodCutting(lengths, prices, 5);
        System.out.println(maxProfit);
    }
}

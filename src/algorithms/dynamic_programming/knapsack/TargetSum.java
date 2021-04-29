package algorithms.dynamic_programming.knapsack;

import java.util.Arrays;

public class TargetSum {
    public int findTargetSubsets(int[] num, int s) {
        // Sum(s1) - Sum(s2) = s -------------(1)
        // Sum(s1) + Sum(s2) = Sum(num) ------(2)
        // Adding equation (1) and (2)
        // 2 * Sum(s1) = s + Sum(num)
        // Sum(s1) = (s + Sum(num)) / 2
        // Now the problem deduced to count of subsets with the given target

        CountOfSubsetSum countOfSubsetSum = new CountOfSubsetSum();
        int target = (s + Arrays.stream(num).sum()) / 2;
        return countOfSubsetSum.countSubsetsMemoization(num, target);
    }

    public static void main(String[] args) {
        TargetSum ts = new TargetSum();
        int[] num = {1, 1, 2, 3};
        System.out.println(ts.findTargetSubsets(num, 1));
        num = new int[]{1, 2, 7, 1};
        System.out.println(ts.findTargetSubsets(num, 9));
    }
}

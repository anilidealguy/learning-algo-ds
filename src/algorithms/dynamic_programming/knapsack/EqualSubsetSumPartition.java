package algorithms.dynamic_programming.knapsack;

import java.util.Arrays;

public class EqualSubsetSumPartition {
    public static void main(String[] args) {
        SubsetSum subsetSum = new SubsetSum();
        EqualSubsetSumPartition e = new EqualSubsetSumPartition();
        int[] num = { 1, 2, 3, 4 };
        System.out.println(e.canPartition(num, subsetSum));
        num = new int[] { 1, 1, 3, 4, 7 };
        System.out.println(e.canPartition(num, subsetSum));
        num = new int[] { 2, 3, 4, 6 };
        System.out.println(e.canPartition(num, subsetSum));
    }

    private boolean canPartition(int[] num, SubsetSum subsetSum) {
        int sum = Arrays.stream(num).sum();
        if (sum %2 != 0)
            return false;

        return  subsetSum.canPartitionRecursive(num, sum/2);
    }
}

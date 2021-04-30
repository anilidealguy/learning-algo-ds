package algorithms.dynamic_programming.fibonacci;

public class MinimumJumpsToEnd {
    public int countMinJumpsMemoization(int[] jumps) {
        return countMinJumpsMemoization(jumps, new int[jumps.length], 0);
    }

    private int countMinJumpsMemoization(int[] jumps, int[] memo, int i) {
        if (i == jumps.length-1)
            return 0;

        if (i >= jumps.length)
            return Integer.MAX_VALUE;

        if (memo[i] != 0)
            return memo[i];

        int res = Integer.MAX_VALUE;

        for (int j = 1; j <= jumps[i]; j++) {
            int i1 = countMinJumpsMemoization(jumps, memo, i + j);
            res = Math.min(res, i1 == Integer.MAX_VALUE ? Integer.MAX_VALUE : i1+1);
        }

        memo[i] = res;
        return res;
    }

    public int countMinJumpsRecursive(int[] jumps) {
        return countMinJumpsRecursive(jumps, 0);
    }

    private int countMinJumpsRecursive(int[] jumps, int i) {
        if (i == jumps.length-1)
            return 0;

        if (i >= jumps.length)
            return Integer.MAX_VALUE;

        int res = Integer.MAX_VALUE;

        for (int j = 1; j <= jumps[i]; j++) {
            int i1 = countMinJumpsRecursive(jumps, i + j);
            res = Math.min(res, i1 == Integer.MAX_VALUE ? Integer.MAX_VALUE : i1+1);
        }

        return res;
    }

    public static void main(String[] args) {
        MinimumJumpsToEnd aj = new MinimumJumpsToEnd();
        int[] jumps = {2, 1, 1, 1, 4};
        System.out.println(aj.countMinJumpsRecursive(jumps));
        jumps = new int[]{1, 1, 3, 6, 9, 3, 0, 1, 3};
        System.out.println(aj.countMinJumpsRecursive(jumps));

        jumps = new int[]{2, 1, 1, 1, 4};
        System.out.println(aj.countMinJumpsMemoization(jumps));
        jumps = new int[]{1, 1, 3, 6, 9, 3, 0, 1, 3};
        System.out.println(aj.countMinJumpsMemoization(jumps));
    }
}

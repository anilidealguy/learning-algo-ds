package algorithms.dynamic_programming.fibonacci;

public class NumberFactors {
    public int countWaysMemoization(int n) {
        int[] memo = new int[n+1];

        if (n == 0 || n == 1 || n == 2)
            memo[n] = 1;

        if (n == 3)
            memo[3] = 2;

        return countWaysMemoization(n, memo);
    }

    private int countWaysMemoization(int n, int[] memo) {
        if (memo[n] != 0)
            return memo[n];

        int res = countWaysRecursive(n-1) + countWaysRecursive(n-3) + countWaysRecursive(n-4);
        memo[n] = res;
        return res;
    }

    public int countWaysRecursive(int n) {
        if (n == 0 || n == 1 || n == 2)
            return 1;
        if (n == 3)
            return 2;

        return countWaysRecursive(n-1) + countWaysRecursive(n-3) + countWaysRecursive(n-4);
    }

    public static void main(String[] args) {
        NumberFactors en = new NumberFactors();
        System.out.println(en.countWaysRecursive(4));
        System.out.println(en.countWaysRecursive(5));
        System.out.println(en.countWaysRecursive(6));

        System.out.println(en.countWaysMemoization(4));
        System.out.println(en.countWaysMemoization(5));
        System.out.println(en.countWaysMemoization(6));
    }
}

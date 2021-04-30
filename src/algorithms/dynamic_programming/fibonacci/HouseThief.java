package algorithms.dynamic_programming.fibonacci;

public class HouseThief {
    public int findMaxStealMemoization(int[] wealth) {
        return findMaxStealMemoization(wealth, new int[wealth.length],wealth.length-1);
    }

    private int findMaxStealMemoization(int[] wealth, int[] memo, int currHouse) {
        if (currHouse < 0)
            return 0;

        if (memo[currHouse] != 0)
            return memo[currHouse];

        memo[currHouse] = Math.max(
                wealth[currHouse] + findMaxStealMemoization(wealth, memo, currHouse - 2),
                findMaxStealMemoization(wealth, memo, currHouse - 1)
        );

        return memo[currHouse];
    }

    public int findMaxStealRecursive(int[] wealth) {
        return findMaxStealRecursive(wealth, wealth.length-1);
    }

    private int findMaxStealRecursive(int[] wealth, int currHouse) {
        if (currHouse < 0)
            return 0;

        return Math.max(
                wealth[currHouse] + findMaxStealRecursive(wealth, currHouse-2),
                findMaxStealRecursive(wealth, currHouse-1)
        );
    }

    public static void main(String[] args) {
        HouseThief ht = new HouseThief();
        int[] wealth = {2, 5, 1, 3, 6, 2, 4};
        System.out.println(ht.findMaxStealRecursive(wealth));
        wealth = new int[]{2, 10, 14, 8, 1};
        System.out.println(ht.findMaxStealRecursive(wealth));

        wealth = new int[]{2, 5, 1, 3, 6, 2, 4};
        System.out.println(ht.findMaxStealMemoization(wealth));
        wealth = new int[]{2, 10, 14, 8, 1};
        System.out.println(ht.findMaxStealMemoization(wealth));
    }
}

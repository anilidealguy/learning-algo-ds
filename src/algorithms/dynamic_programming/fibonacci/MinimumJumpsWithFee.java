package algorithms.dynamic_programming.fibonacci;

public class MinimumJumpsWithFee {
    public int findMinFeeMemoization(int[] fee) {
        return findMinFeeMemoization(fee, new int[fee.length],0);
    }

    private int findMinFeeMemoization(int[] fee, int[] memo, int currStep) {
        if (currStep >= fee.length)
            return 0;

        if (memo[currStep] != 0)
            return memo[currStep];

        memo[currStep] = fee[currStep] + Math.min(findMinFeeMemoization(fee, memo, currStep + 1),
                Math.min(findMinFeeMemoization(fee, memo, currStep + 2),
                        findMinFeeMemoization(fee, memo, currStep + 3)
                )
        );

        return memo[currStep];
    }

    public int findMinFeeRecursive(int[] fee) {
        return findMinFeeRecursive(fee, 0);
    }

    private int findMinFeeRecursive(int[] fee, int currStep) {
        if (currStep >= fee.length)
            return 0;

        return fee[currStep] + Math.min(findMinFeeRecursive(fee, currStep+1),
                Math.min(findMinFeeRecursive(fee, currStep+2),
                        findMinFeeRecursive(fee, currStep+3)
                )
        );
    }

    public static void main(String[] args) {
        MinimumJumpsWithFee sc = new MinimumJumpsWithFee();
        int[] fee = {1,2,5,2,1,2};
        System.out.println(sc.findMinFeeRecursive(fee));
        fee = new int[]{2,3,4,5};
        System.out.println(sc.findMinFeeRecursive(fee));

        fee = new int[]{1,2,5,2,1,2};
        System.out.println(sc.findMinFeeMemoization(fee));
        fee = new int[]{2,3,4,5};
        System.out.println(sc.findMinFeeMemoization(fee));
    }
}

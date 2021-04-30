package algorithms.dynamic_programming.unbounded_knapsack;

public class MaximumRibbonCut {
    public int countRibbonPiecesMemoization(int[] ribbonLengths, int total) {
        int res = countRibbonPiecesMemoization(ribbonLengths, total, new Integer[ribbonLengths.length][total+1],ribbonLengths.length - 1);
        return res == Integer.MIN_VALUE ? -1 : res;
    }

    public int countRibbonPiecesMemoization(int[] ribbonLengths, int total, Integer[][] memo,int i) {
        if (total < 0 || i < 0)
            return Integer.MIN_VALUE;

        if (total == 0)
            return 0;

        if (memo[i][total] != null)
            return memo[i][total];

        int pick = Integer.MIN_VALUE;
        if (ribbonLengths[i] <= total) {
            pick = countRibbonPiecesMemoization(ribbonLengths, total - ribbonLengths[i], memo, i);
            if (pick != Integer.MIN_VALUE)
                pick++;
        }

        int unPick = countRibbonPiecesMemoization(ribbonLengths, total, memo, i-1);

        int res = Math.max(pick, unPick);
        memo[i][total] = res;
        return res;
    }

    public int countRibbonPiecesRecursive(int[] ribbonLengths, int total) {
        int res = countRibbonPiecesRecursive(ribbonLengths, total, ribbonLengths.length - 1);
        return res == Integer.MIN_VALUE ? -1 : res;
    }

    public int countRibbonPiecesRecursive(int[] ribbonLengths, int total, int i) {
        if (total < 0 || i < 0)
            return Integer.MIN_VALUE;

        if (total == 0)
            return 0;

        int pick = Integer.MIN_VALUE;
        if (ribbonLengths[i] <= total) {
            pick = countRibbonPiecesRecursive(ribbonLengths, total - ribbonLengths[i], i);
            if (pick != Integer.MIN_VALUE)
                pick++;
        }

        int unPick = countRibbonPiecesRecursive(ribbonLengths, total, i-1);

        return Math.max(pick, unPick);
    }

    public static void main(String[] args) {
        MaximumRibbonCut cr = new MaximumRibbonCut();
        int[] ribbonLengths = {2,3,5};
        System.out.println(cr.countRibbonPiecesRecursive(ribbonLengths, 5));
        ribbonLengths = new int[]{2,3};
        System.out.println(cr.countRibbonPiecesRecursive(ribbonLengths, 7));
        ribbonLengths = new int[]{3,5,7};
        System.out.println(cr.countRibbonPiecesRecursive(ribbonLengths, 13));
        ribbonLengths = new int[]{3,5};
        System.out.println(cr.countRibbonPiecesRecursive(ribbonLengths, 7));

        ribbonLengths = new int[]{2,3,5};
        System.out.println(cr.countRibbonPiecesMemoization(ribbonLengths, 5));
        ribbonLengths = new int[]{2,3};
        System.out.println(cr.countRibbonPiecesMemoization(ribbonLengths, 7));
        ribbonLengths = new int[]{3,5,7};
        System.out.println(cr.countRibbonPiecesMemoization(ribbonLengths, 13));
        ribbonLengths = new int[]{3,5};
        System.out.println(cr.countRibbonPiecesMemoization(ribbonLengths, 7));
    }
}

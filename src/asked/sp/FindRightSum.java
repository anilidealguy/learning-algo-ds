package asked.sp;

public class FindRightSum {

    private int findRightSum(TreeNode curr) {
        if (curr == null)
            return 0;

        // Single node in a tree
        if (curr.left == null && curr.right == null)
            return curr.val;

        int res = 0;
        if (curr.right != null) {
            if (curr.right.right == null)
                res = res + curr.right.val;
            else
                res = res + findRightSum(curr.right);
        }

        if (curr.left != null) {
            if (curr.left.right != null)
                res = res + findRightSum(curr.left);
        }

        return res;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}

package datastructures.trees;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearchRecurssive {
    public List<List<Integer>> doDFS(TreeNode root) {
        List<List<Integer>> traversals = new ArrayList<>();
        
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();

        inOrderTraversal(root, inOrder);
        preOrderTraversal(root, preOrder);
        postOrderTraversal(root, postOrder);

        traversals.add(inOrder);
        traversals.add(preOrder);
        traversals.add(postOrder);
        return traversals;
    }

    private void inOrderTraversal(TreeNode root, List<Integer> result) {
        if (root == null)
            return;

        inOrderTraversal(root.left, result);
        result.add(root.val);
        inOrderTraversal(root.right, result);
    }

    private void preOrderTraversal(TreeNode root, List<Integer> result) {
        if (root == null)
            return;

        result.add(root.val);
        preOrderTraversal(root.left, result);
        preOrderTraversal(root.right, result);
    }

    private void postOrderTraversal(TreeNode root, List<Integer> result) {
        if (root == null)
            return;

        postOrderTraversal(root.left, result);
        postOrderTraversal(root.right, result);
        result.add(root.val);
    }
}
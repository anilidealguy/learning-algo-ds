package datastructures.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearchIterative {
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

        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }

            TreeNode node = stack.pop();
            result.add(node.val);
            root = node.right;
        }
    }

    private void preOrderTraversal(TreeNode root, List<Integer> result) {
        if (root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.add(root);
                result.add(root.val);
                root = root.left;
            }
            TreeNode node = stack.pop();
            root = node.right;
        }
    }

    private void postOrderTraversal(TreeNode root, List<Integer> result) {
        if (root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.add(root);
                result.add(root.val);
                root = root.left;
            }
            TreeNode node = stack.pop();
            root = node.right;
            result.add(node.val);
        }
    }
}
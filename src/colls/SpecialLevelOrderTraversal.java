package colls;

import java.util.*;
import java.util.stream.Collectors;

public class SpecialLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = null;

        Deque<TreeNode> deque = new ArrayDeque<>();
        Deque<TreeNode> level = new ArrayDeque<>();
        deque.addFirst(root);
        level.addFirst(root);

        List<Integer> res = new LinkedList<>();

        while(!deque.isEmpty()) {
            while(!level.isEmpty()) {
                TreeNode first = level.getFirst();
                TreeNode last = level.getLast();

                res.add(0, first.left.data);
                res.add(0, last.right.data);
                res.add(0, first.right.data);
                res.add(0, last.left.data);
            }

            int size = deque.size();
            while(size > 0) {
                TreeNode first = deque.getFirst();
                deque.addFirst(first);
                level.addFirst(first);
                size--;
            }

        }

        System.out.println(res.stream().map(String::valueOf).collect(Collectors.joining(", ")));
    }

}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
}

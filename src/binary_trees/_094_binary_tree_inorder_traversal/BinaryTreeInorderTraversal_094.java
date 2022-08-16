package binary_trees._094_binary_tree_inorder_traversal;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal_094 {
    // Left -> Node -> Right
    // Time: O(N), Space: O(1)
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    public static void inorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }

    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        r1.left = null;
        r1.right = n2;
        n2.left = n3;
        n2.right = null;
        n3.left = null;
        n3.right = null;

        TreeNode r3 = new TreeNode(1);

        System.out.println(inorderTraversal(r1));
        System.out.println(inorderTraversal(null));
        System.out.println(inorderTraversal(r3));
    }
}

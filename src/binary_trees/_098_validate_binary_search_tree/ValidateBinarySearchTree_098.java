package binary_trees._098_validate_binary_search_tree;

import utils.TreeNode;

import java.util.Stack;

public class ValidateBinarySearchTree_098 {
    // inorder traversal
    // Time: O(N), Space: O(N)
    public static boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        double leftVal = - Integer.MAX_VALUE; // min value possible

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (root.val <= leftVal) {
                return false;
            }
            leftVal = root.val;
            root = root.right;
        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        r1.left = n2;
        r1.right = n3;

        System.out.println(isValidBST(r1));

        TreeNode r2 = new TreeNode(5);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(3);
        TreeNode n7 = new TreeNode(6);
        r2.left = n4;
        r2.right = n5;
        n5.left = n6;
        n5.right = n7;

        System.out.println(isValidBST(r2));
    }
}

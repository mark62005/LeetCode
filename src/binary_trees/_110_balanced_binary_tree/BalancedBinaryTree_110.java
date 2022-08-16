package binary_trees._110_balanced_binary_tree;

import utils.TreeNode;

public class BalancedBinaryTree_110 {
    // postorder traversal (DFS)
    // Time: O(N), Space: O(N)
    public static boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    private static int getHeight(TreeNode node) {
        if (node == null) return 0;

        int left = getHeight(node.left);
        int right = getHeight(node.right);

        // left, right subtree is unbalanced or cur tree is unbalanced
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;

        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);
        r1.left = n2;
        r1.right = n3;
        n3.left = n4;
        n3.right = n5;

        System.out.println(isBalanced(r1));

        TreeNode r2 = new TreeNode(1);
        TreeNode n6 = new TreeNode(2);
        TreeNode n7 = new TreeNode(2);
        TreeNode n8 = new TreeNode(3);
        TreeNode n9 = new TreeNode(3);
        TreeNode n10 = new TreeNode(4);
        TreeNode n11 = new TreeNode(4);
        r2.left = n6;
        r2.right = n7;
        n6.left = n8;
        n6.right = n9;
        n8.left = n10;
        n8.right = n11;

        System.out.println(isBalanced(r2));

        System.out.println(isBalanced(null));
    }
}

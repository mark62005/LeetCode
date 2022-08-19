import utils.TreeNode;

public class BinaryTreeMaximumPathSum_124 {
    // Time: O(N), Space: O(N)
    static int maxSum;
    public static int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxPathSumHelper(root);
        return maxSum;
    }

    private static int maxPathSumHelper(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int lhs = Math.max(0, maxPathSumHelper(node.left));
        int rhs = Math.max(0, maxPathSumHelper(node.right));
        maxSum = Math.max(maxSum, lhs + rhs + node.val);

        return Math.max(lhs, rhs) + node.val;
    }

    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        r1.left = n2;
        r1.right = n3;

        System.out.println(maxPathSum(r1));

        TreeNode r2 = new TreeNode(-10);
        TreeNode n4 = new TreeNode(9);
        TreeNode n5 = new TreeNode(20);
        TreeNode n6 = new TreeNode(15);
        TreeNode n7 = new TreeNode(7);
        r2.left = n4;
        r2.right = n5;
        n5.left = n6;
        n5.right = n7;

        System.out.println(maxPathSum(r2));
    }
}

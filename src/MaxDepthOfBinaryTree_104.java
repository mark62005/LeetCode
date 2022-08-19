import utils.TreeNode;

public class MaxDepthOfBinaryTree_104 {
    // Time: O(N), Space: O(N)
    public static int maxDepth(TreeNode root) {
        // base case
        if (root == null) {
            return 0;
        }

        // recursive case
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
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

        TreeNode r2 = new TreeNode(1);
        r2.right = new TreeNode(2);

        System.out.println(maxDepth(r1));
        System.out.println(maxDepth(r2));
    }
}

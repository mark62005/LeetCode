import utils.TreeNode;

public class LowestCommonAncestorOfABinaryTree_236 {
    // Time: O(N), Space: O(H)
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base case
        if (root == null || p == root || q == root) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left , p , q);
        TreeNode right = lowestCommonAncestor(root.right , p , q);
        // iterative case
        if (right == null) {
            return left;
        }
        if (left == null) {
            return right;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(6);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(0);
        TreeNode n7 = new TreeNode(8);
        TreeNode n8 = new TreeNode(7);
        TreeNode n9 = new TreeNode(4);
        r1.left = n2;
        r1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n5.left = n8;
        n5.right = n9;

        System.out.println(lowestCommonAncestor(r1, n2, n3));
        System.out.println(lowestCommonAncestor(r1, n2, n9));
    }
}

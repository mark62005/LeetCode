package binary_trees._543_diameter_of_binary_tree;

import utils.TreeNode;

public class Diameter_Of_Binary_Tree_543 {
    // Time: O(N), Space: O(N)
    static class Edge {
        int height;
        int diameter;

        public Edge() {}

        public Edge(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        // base case
        if (root == null) {
            return 0;
        }

        // iterative case
        Edge answer = diameterOfBinaryTreeHelper(root);
        return answer.diameter;
    }

    private static Edge diameterOfBinaryTreeHelper(TreeNode root) {
        if (root == null) {
            return new Edge(-1, 0);
        }

        Edge lhs = diameterOfBinaryTreeHelper(root.left);
        Edge rhs = diameterOfBinaryTreeHelper(root.right);
        Edge edge = new Edge();
        edge.diameter = Math.max(lhs.height+rhs.height+2, Math.max(lhs.diameter, rhs.diameter));
        edge.height = Math.max(lhs.height, rhs.height)+1;
        return edge;
    }

    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        r1.left = n2;
        r1.right = n3;
        n2.left = n4;
        n2.right = n5;

        System.out.println(diameterOfBinaryTree(r1));

        TreeNode r2 = new TreeNode(1);
        r2.left = new TreeNode(2);

        System.out.println(diameterOfBinaryTree(r2));
    }
}

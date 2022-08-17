package binary_trees;

import utils.ListNode;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInABST_230 {
    public static int kthSmallest(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        inOrder(root, result, k);
        return result.get(k - 1);
    }

    public static void inOrder(TreeNode root, List<Integer> result, int k){
        if (result.size() == k) {
            return;
        }

        if (root == null) {
            return;
        }

        inOrder(root.left, result, k);
        result.add(root.val);
        inOrder(root.right, result, k);
    }

    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(2);
        r1.left = n2;
        r1.right = n3;
        n2.right = n4;
        System.out.println(kthSmallest(r1, 1));

        TreeNode r2 = new TreeNode(5);
        TreeNode n6 = new TreeNode(3);
        TreeNode n7 = new TreeNode(6);
        TreeNode n8 = new TreeNode(2);
        TreeNode n9 = new TreeNode(4);
        TreeNode n10 = new TreeNode(1);
        r2.left = n6;
        r2.right = n7;
        n6.left = n8;
        n6.right = n9;
        n8.left = n10;
        System.out.println(kthSmallest(r2, 3));
    }
}

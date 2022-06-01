package leetcodeproblems.LC_101_200;

import datastructures.TreeNode;

//110. [Balanced Binary Tree](https://leetcode.com/problems/balanced-binary-tree)
public class S_110_BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }

        int leftDepth = helper(root.left);
        int rightDepth = helper(root.right);

        if(Math.abs(leftDepth - rightDepth) <= 1 && isBalanced(root.left) && isBalanced(root.right)) {
            return true;
        }

        return false;
    }

    private int helper(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return Math.max(helper(root.left), helper(root.right)) + 1;
    }
}

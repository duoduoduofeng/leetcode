package leetcodeproblems.LC_101_200;

import datastructures.TreeNode;

//112. [Path Sum](https://leetcode.com/problems/path-sum)
public class S_112_PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return false;
        }

        if(root.left == null && root.right == null && root.val == targetSum) {
            return true;
        }

        if(hasPathSum(root.left, targetSum-root.val) || hasPathSum(root.right, targetSum-root.val)) {
            return true;
        }

        return false;
    }
}

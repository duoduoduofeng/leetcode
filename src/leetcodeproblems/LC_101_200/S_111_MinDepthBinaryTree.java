package leetcodeproblems.LC_101_200;

import datastructures.TreeNode;

//111. [Minimum Depth of Binary Tree](https://leetcode.com/problems/minimum-depth-of-binary-tree)
public class S_111_MinDepthBinaryTree {
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left_depth = minDepth(root.left);
        int right_depth = minDepth(root.right);

        if(root.left == null) {
            return 1 + right_depth;
        }

        if(root.right == null) {
            return 1 + left_depth;
        }

        return 1 + Math.min(left_depth, right_depth);
    }
}

package leetcodeproblems.LC_101_200;

import datastructures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

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

    // non-recursive
    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // if (root.left == null && root.right == null) {
        //     return 1;
        // }

        TreeNode p = root;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(p);
        int depth = 0;

        int curLen = nodes.size();
        while(curLen > 0) {
            depth++;
            for(int i = 0; i < curLen; i++) {
                p = nodes.poll();

                if (p.left == null) {
                    if(p.right == null) {
                        return depth;
                    }
                } else {
                    nodes.add(p.left);
                }

                if (p.right != null) {
                    nodes.add(p.right);
                }

            }

            curLen = nodes.size();
        }

        return depth;
    }
}

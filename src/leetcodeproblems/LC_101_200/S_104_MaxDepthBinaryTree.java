package leetcodeproblems.LC_101_200;

//104. [Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree)

import datastructures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class S_104_MaxDepthBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

         if(root.left == null && root.right == null) {
             return 1;
         }

         return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    // non-recursive way
    public int maxDepth2(TreeNode root) {
        Queue<TreeNode> nodes = new LinkedList<TreeNode>();
        nodes.add(root);
        TreeNode p = null;
        int depth = 0;

        while(nodes.size() > 0){
            depth++;
            int curLen = nodes.size();
            for(int i = 0; i< curLen; i++) {
                p = nodes.poll();
                if(p.left != null) {
                    nodes.add(p.left);
                }
                if(p.right != null) {
                    nodes.add(p.right);
                }
            }
        }

        return depth;
    }
}

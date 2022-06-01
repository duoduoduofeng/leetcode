package leetcodeproblems.LC_201_300;

import datastructures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//226. [Invert Binary Tree](https://leetcode.com/problems/invert-binary-tree)
public class S_226_InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) {
            return root;
        }
        // recursive way
//         TreeNode tmp = root.left;
//         root.left = invertTree(root.right);
//         root.right = invertTree(tmp);

//         return root;

        // non-recursive way
        // layer traverse
        Queue<TreeNode> nodes = new LinkedList<TreeNode>();
        nodes.add(root);

        while(nodes.size() > 0) {
            int curSize = nodes.size();
            for(int i = 0; i < curSize; i++) {
                TreeNode nd = nodes.poll();

                TreeNode tmp = nd.left;
                nd.left = nd.right;
                nd.right = tmp;

                if(nd.left != null) {
                    nodes.add(nd.left);
                }
                if(nd.right != null) {
                    nodes.add(nd.right);
                }

            }
        }

        return root;
    }
}

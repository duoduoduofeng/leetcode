package leetcodeproblems.LC_001_100;

import datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 94. [Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal)

public class S_094_BinaryTreeInorderTraverse {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> rs = new ArrayList<Integer>();

        if(root == null) {
            return rs;
        }

        Stack<TreeNode> nodes = new Stack<TreeNode>();
        TreeNode nd = root;

        while(nd != null || nodes.size() > 0) {
            if(nd != null) {
                nodes.push(nd)  ;
                nd = nd.left;
            } else {
                nd = nodes.pop();
                rs.add(nd.val);
                nd = nd.right;
            }
        }

        return rs;
    }
}

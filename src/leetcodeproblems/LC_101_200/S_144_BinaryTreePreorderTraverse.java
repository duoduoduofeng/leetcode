package leetcodeproblems.LC_101_200;

import datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/binary-tree-preorder-traversal/
public class S_144_BinaryTreePreorderTraverse {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> rs = new ArrayList<>();

        if(root == null) {
            return rs;
        }

        TreeNode p = root;
        Stack<TreeNode> nodes = new Stack<>();

        while(p != null || nodes.size() > 0) {
            if(p != null) {
                nodes.add(p);
                rs.add(p.val);
                p = p.left;
            } else {
                p = nodes.pop();
                p = p.right; // The next time in while loop, p.right will be judged whether null.
            }
        }

        return rs;

    }
}

package leetcodeproblems.LC_101_200;

//102. [Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal)

import datastructures.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class S_102_BinaryTreeLevelOrderTraverse {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> rs = new ArrayList<>();
        if(root == null) {
            return rs;
        }

        Queue<TreeNode> nodes = new LinkedList<>();

        TreeNode p = root;
        nodes.add(p);

        while(nodes.size() > 0) {
            int curLen = nodes.size();
            List<Integer> curRs = new ArrayList<>();

            for(int i = 0; i < curLen; i++) {
                p = nodes.poll();
                curRs.add(p.val);
                if(p.left != null) {
                    nodes.add(p.left);
                }
                if(p.right != null) {
                    nodes.add(p.right);
                }
            }

            rs.add(curRs);
        }

        return rs;
    }
}

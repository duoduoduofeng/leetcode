package leetcodeproblems.LC_101_200;

import datastructures.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//145. [Binary Tree Postorder Traversal](https://leetcode.com/problems/binary-tree-postorder-traversal)
public class S_145_BinaryTreePostorderTraverse {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> rs = new ArrayList<Integer>();
        if(root == null) {
            return rs;
        }

        Stack<TreeNode> nodes = new Stack<TreeNode>();
        nodes.push(root);
        TreeNode p = null;
        TreeNode pre = null;

        while(nodes.size()>0) {
            p = nodes.peek(); // just get the last node but not pop it out
            if((p.left == null && p.right == null) ||
                    (pre != null && (pre == p.left || pre == p.right))) { // more efficient
//            if((p.left == null && p.right == null) ||
//                    (p.left != null && pre == p.left) ||
//                    (p.right != null && pre == p.right)) { // more elegant
                rs.add(p.val);
                nodes.pop();
                pre = p;
            } else {
                if(p.right != null) {
                    nodes.push(p.right);
                }
                if(p.left != null) {
                    nodes.push(p.left);
                }
            }
        }
        return rs;
    }
}

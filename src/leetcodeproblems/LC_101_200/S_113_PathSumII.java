package leetcodeproblems.LC_101_200;

import datastructures.TreeNode;
import java.util.ArrayList;
import java.util.List;

//113. [Path Sum II](https://leetcode.com/problems/path-sum-ii)
public class S_113_PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> rs = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        helper(root, targetSum, path, rs);
        return rs;
    }

    private void helper(TreeNode root, int targetSum, List<Integer> path, List<List<Integer>> rs) {
        if(root == null) {
            return;
        }

        path.add(root.val);
        if(root.left == null && root.right == null && root.val == targetSum) {
            rs.add(new ArrayList<Integer>(path)); // must copy it, or will be erased
        }

        helper(root.left, targetSum - root.val, path, rs);
        helper(root.right, targetSum - root.val, path, rs);

        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        S_113_PathSumII ex = new S_113_PathSumII();
        List<List<Integer>> steps = ex.pathSum(root, 22);
        System.out.print(steps);
    }
}

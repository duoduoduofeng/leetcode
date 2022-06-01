package leetcodeproblems.LC_101_200;

import datastructures.TreeNode;

//105. [Construct Binary Tree from Preorder and Inorder Traversal]
// (https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal)
public class S_105_ReconstructBinaryTreePreIn {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }

        return helper(preorder, inorder, 0, preorder.length - 1,
                0 , inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int preStart, int preEnd,
                            int inStart, int inEnd) {
        if(preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);

        int leftLen = 0;
        int i = inStart;
        while(i <= inEnd && inorder[i] != preorder[preStart]) {
            ++i;
        }
        leftLen = i - inStart;

        root.left = helper(preorder, inorder, preStart + 1, preStart + leftLen,
                inStart, i - 1);
        root.right = helper(preorder, inorder, preStart + leftLen + 1, preEnd,
                i + 1, inEnd);

        return root;
    }

    public static void main(String[] args) {
        S_105_ReconstructBinaryTreePreIn ex = new S_105_ReconstructBinaryTreePreIn();
        TreeNode steps = ex.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        System.out.print(steps.val);
    }
}

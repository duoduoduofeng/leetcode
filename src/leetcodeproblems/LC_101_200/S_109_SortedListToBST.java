package leetcodeproblems.LC_101_200;

//109. [Convert Sorted List to Binary Search Tree]
// (https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree)

import datastructures.ListNode;
import datastructures.TreeNode;

public class S_109_SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) {
            return null;
        }
        if(head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = head;
        while(fast != null && fast.next != null) {
            pre = slow;
            fast = fast.next.next;
            slow = slow.next;
        }

        pre.next = null;
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head); // the list must be changed, so use head but not its copy.
        root.right = sortedListToBST(slow.next);

        return root;
    }
}

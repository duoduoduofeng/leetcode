package leetcodeproblems.LC_001_100;

import datastructures.ListNode;

public class S_083_RemoveDuplicatesOfSortedList {
    // https://leetcode.com/problems/remove-duplicates-from-sorted-list/
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode left = head;
        ListNode right = head.next;

        while(right != null) {
            if(right.val != left.val) {
                left.next = right;
                left = left.next;
            }
            right = right.next;
        }

        left.next = null; // Remove all the duplicates of last left node.
        return head;
    }
}

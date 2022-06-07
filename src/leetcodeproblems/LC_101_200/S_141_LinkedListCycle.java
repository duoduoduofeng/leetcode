package leetcodeproblems.LC_101_200;

import datastructures.ListNode;

//https://leetcode.com/problems/linked-list-cycle/
public class S_141_LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null) {
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null) {
            // Move at least one step.
            fast = fast.next.next;
            slow = slow.next;

            if(slow == fast) {
                return true;
            }
        }

        return false;
    }
}

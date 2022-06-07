package leetcodeproblems.LC_101_200;

import datastructures.ListNode;

//https://leetcode.com/problems/linked-list-cycle-ii/
public class S_142_LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if(head == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        ListNode finder = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if(slow == fast) {
                while(slow != finder) {
                    slow = slow.next;
                    finder = finder.next;
                }
                return finder;
            }
        }

        return null;
    }
}

package leetcodeproblems.LC_001_100;

import datastructures.ListNode;

//https://leetcode.com/problems/remove-nth-node-from-end-of-list/submissions/
public class S_019_RemoveNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 1<=n<=size is guaranteed
        if(head == null || head.next == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;

        ListNode helper = new ListNode(-1);
        ListNode dummy = helper;
        // This design is very important because it can cover the condition n=size.
        helper.next = head;

        int steps = 0;
        while(fast != null && fast.next != null && steps < n - 1) {
            fast = fast.next;
            ++steps;
        }

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            helper = helper.next;
        }

        helper.next = slow.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        S_019_RemoveNthNode ex = new S_019_RemoveNthNode();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);

        int n = 2;
        ListNode newhead = ex.removeNthFromEnd(head, n);

        while(newhead != null) {
            System.out.println(newhead.val);
            newhead = newhead.next;
        }
    }
}

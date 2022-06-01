package leetcodeproblems.LC_201_300;

import datastructures.ListNode;

//206. [Reverse Linked List](https://leetcode.com/problems/reverse-linked-list)
public class S_206_ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        // recursive way
//         ListNode tmp = head.next;
//         ListNode newhead = reverseList(head.next);
//         tmp.next = head;
//         head.next = null;

//         return newhead;

        //  non-recursive way
//         ListNode next = head;
//         ListNode pre = null;
//         while(next != null) {
//             ListNode pre_tmp = next;
//             ListNode next_tmp = next.next;
//             next.next = pre;
//             pre = pre_tmp;
//             next = next_tmp;
//         }

//         return pre;

        // more elegant non-recursive way
        ListNode node = head;
        ListNode pre = null, next = null;

        while(node != null) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }

        return pre;
    }
}

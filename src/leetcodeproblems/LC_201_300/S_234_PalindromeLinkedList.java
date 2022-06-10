package leetcodeproblems.LC_201_300;

import datastructures.ListNode;

//https://leetcode.com/problems/palindrome-linked-list/
// no need to judge even or odd number of nodes? https://blog.csdn.net/Just_do_myself/article/details/119827059
public class S_234_PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        // edge cases
        if(head == null || head.next == null) {
            return true;
        }

        // general
        int len = 0;
        ListNode p = head;
        while(p != null) {
            p = p.next;
            len++;
        }

        boolean needInsert = false;
        if(len % 2 == 0) { // even number of nodes
            needInsert = true;
        }
        int mid = len / 2;

        int start = 0;
        p = head;
        while(start < mid - 1) { // move p to the middle node
            p = p.next;
            start++;
        }
        if(needInsert) { // if even number, insert a node in the middle.
            ListNode newMid = new ListNode(-1);
            newMid.next = p.next;
            p.next = newMid;
        }

        p = p.next; // step to the exact middle node
        ListNode pre = p;

        p = p.next; // forward to the next node, start doing the reverse
        ListNode next;
        while(p != null) {
            next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        } // After this, pre is the right head of the list.

        p = head;
        ListNode q = pre;

        while(p != q) {
            if(p.val != q.val) {
                return false;
            }
            p = p.next;
            q = q.next;
        }

        return true;
    }

    public static void main(String[] args) {
        S_234_PalindromeLinkedList ex = new S_234_PalindromeLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        boolean isPalin = ex.isPalindrome(head);
        System.out.println(isPalin);
    }
}

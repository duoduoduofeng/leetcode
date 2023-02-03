package leetcodeproblems.LC_101_200;

import datastructures.ListNode;

//148. [Sort List](https://leetcode.com/problems/sort-list)
public class S_148_SortList {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode fast = head, slow = head, pre = null; // pre should be null and won't cause nullpointerexception.

        while(fast != null && fast.next != null) {
            pre = slow; // slow's parent pointer
            fast = fast.next.next;
            slow = slow.next;
        }

        pre.next = null;

        return merge(sortList(head), sortList(slow));
    }

    ListNode merge(ListNode x, ListNode y) {
        if(x == null) {
            return y;
        }
        if(y == null) {
            return x;
        }

        ListNode dummy = new ListNode(-1);
        ListNode real = dummy;

        ListNode p = x;
        ListNode q = y;

        while(p != null && q != null) {
            if(p.val <= q.val) {
                dummy.next = new ListNode(p.val);
                p = p.next;
            }else {
                dummy.next = new ListNode(q.val);
                q = q.next;
            }
            dummy = dummy.next;
        }

        if(p != null) {
            dummy.next = p;
        }

        if(q != null) {
            dummy.next = q;
        }

        return real.next;
    }
}

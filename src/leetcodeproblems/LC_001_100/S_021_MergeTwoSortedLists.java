package leetcodeproblems.LC_001_100;

import datastructures.ListNode;

//https://leetcode.com/problems/merge-two-sorted-lists/
public class S_021_MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) {
            return list2;
        }
        if(list2 == null) {
            return list1;
        }

        ListNode p = list1;
        ListNode q = list2;
        ListNode rs = new ListNode(-1);
        ListNode dummy = rs;

        while(p != null && q != null) {
            if(p.val <= q.val) {
                rs.next = p;
                p = p.next;
            } else {
                rs.next = q;
                q = q.next;
            }
            rs = rs.next;
        }

        if(p != null) {
            rs.next = p;
        }
        if(q != null) {
            rs.next = q;
        }

        return dummy.next;
    }
}

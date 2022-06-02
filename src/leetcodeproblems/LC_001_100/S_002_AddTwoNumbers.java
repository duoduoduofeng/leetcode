package leetcodeproblems.LC_001_100;

import datastructures.ListNode;

public class S_002_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        ListNode p = l1;
        ListNode q = l2;
        ListNode fake = new ListNode(-1);
        ListNode head = fake;

        int sum = 0;
        int carry = 0;
        int cur = 0;

        while(p != null || q != null) {
            sum = carry;
            if(p != null) {
                sum += p.val;
                p = p.next;
            }

            if(q != null) {
                sum += q.val;
                q = q.next;
            }

            cur = sum % 10;
            carry = sum / 10;

            fake.next = new ListNode(cur);
            fake = fake.next;
        }

        if(carry > 0) {
            fake.next = new ListNode(carry);
        }

        return head.next;
    }
}

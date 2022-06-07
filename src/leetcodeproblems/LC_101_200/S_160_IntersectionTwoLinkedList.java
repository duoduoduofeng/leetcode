package leetcodeproblems.LC_101_200;

import datastructures.ListNode;

//https://leetcode.com/problems/intersection-of-two-linked-lists/
public class S_160_IntersectionTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }

        ListNode pa = headA;
        ListNode pb = headB;
        int lenA = 0;
        int lenB = 0;

        while(pa != null) {
            lenA++;
            pa = pa.next;
        }

        while(pb != null) {
            lenB++;
            pb = pb.next;
        }

        pa = headA;
        pb = headB;

        int aheadSteps = 0;
        if(lenA > lenB) {
            while(aheadSteps < lenA - lenB) {
                pa = pa.next;
                aheadSteps++;
            }
        } else {
            while(aheadSteps < lenB - lenA) {
                pb = pb.next;
                aheadSteps++;
            }
        }

        while(pa != pb && pa != null && pb != null) {
            pa = pa.next;
            pb = pb.next;
        }

        if(pa == null || pb == null) {
            return null;
        }

        return pa;
    }
}

package com.noah.demo;

public class HasCycle {

    public boolean hasCycle(ListNode head) {

        if (head == null) {
            return false;
        }

        ListNode second = head;
        ListNode first = head.next;
        if (first == null) {
            return false;
        }

        while (first != second) {

            if (first == null) {
                return false;
            }

            if (first.next == null) {
                return false;
            }

            first = first.next.next;
            second = second.next;

        }

        return true;
    }


    public ListNode detectCycle(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null) {

            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }

            if (fast == slow) {

                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }

                return ptr;
            }
        }

        return null;
    }


    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}

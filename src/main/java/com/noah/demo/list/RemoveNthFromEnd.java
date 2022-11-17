package com.noah.demo.list;

/**
 * Title: emoveNthFromEnd.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2020/11/22
 */
public class RemoveNthFromEnd {

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0, head);

        ListNode first = head;
        ListNode second = dummy;

        for (int i = 0; i < n; i++) {

            first = first.next;
        }

        while (first != null) {

            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;

    }

}

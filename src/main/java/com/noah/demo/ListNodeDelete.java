package com.noah.demo;

/**
 * Title: ListNodeDelete.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 *
 * @author yinzo 2020/11/9
 */
public class ListNodeDelete {


    public ListNode deleteDuplicates(ListNode head) {

        // 链表为空
        if (head == null) {

            return null;
        }

        ListNode next = head.next;

        // 下个节点为空返回
        if (next == null) {

            return head;
        }
        if (head.val == next.val) {

            //连续相同指针
            while (head.val == next.val) {

                head = next;
                next = next.next;

                //若连续相同指针后，下个指针为空，跳出循环返回空
                if (next == null) {
                    break;
                }
            }

            return deleteDuplicates(next);
        } else {

            head.next = deleteDuplicates(next);
            return head;
        }
    }

    public ListNode deleteDuplicates2(ListNode head) {

        if (head == null) {

            return head;
        }

        ListNode next = head.next;

        if (next == null) {
            return head;
        }


        if (head.val == next.val) {

            while (head.val == next.val) {

                head = next;
                next = next.next;

                // 若下一个指针为空，就跳出循环
                if (next == null) {
                    break;
                }
            }

            return deleteDuplicates2(next);
        } else {

            head.next = deleteDuplicates2(next);
            return head;
        }


    }


    public static void main(String[] args) {

        ListNode listNode = new ListNode(1);
        ListNode listNode1 = listNode.next = new ListNode(2);
        ListNode listNode2 = listNode1.next = new ListNode(3);
        ListNode listNode3 = listNode2.next = new ListNode(3);
        ListNode listNode4 = listNode3.next = new ListNode(4);


        ListNode result = new ListNodeDelete().deleteDuplicates(listNode);

        if (result != null) {

            System.out.println(result.val);

            while (result.next != null) {
                System.out.println(result.next.val);
                result = result.next;
            }

        }

    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}


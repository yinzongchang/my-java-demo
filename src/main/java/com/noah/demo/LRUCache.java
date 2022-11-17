package com.noah.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: LRUCache.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2020/11/22
 */
public class LRUCache {

    static class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;


        public DLinkedNode() {
        }

        public DLinkedNode(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;

    private DLinkedNode head, tail;

    public LRUCache(int capacity) {

        this.size = 0;
        this.capacity = capacity;

        // 使用伪头部、尾部 -- 这两个虚拟节点真的是巧妙
        this.head = new DLinkedNode();
        this.tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {

        DLinkedNode node = cache.get(key);
        if (node == null) {

            return -1;
        }

        moveToHead(node);
        return node.value;

    }

    public void put(int key, int value) {

        DLinkedNode node = cache.get(key);

        if (node == null) {

            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);
            addHead(newNode);


            size++;
            // 判断是否超过容量
            if (size > capacity) {

                DLinkedNode removeNode = removeTail();

                // 删除哈希表中内容
                cache.remove(removeNode.key);
                size--;

            }
        } else {
            node.value = value;
            moveToHead(node);
        }


    }

    private void addHead(DLinkedNode node) {

//        DLinkedNode tempNode = head.next;
//        head.next = node;
//        node.next = tempNode;
//        node.prev = head;
//        tempNode.prev = node;
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addHead(node);
    }

    private DLinkedNode removeTail() {

        DLinkedNode node = tail.prev;
        removeNode(node);

        return node;
    }

}

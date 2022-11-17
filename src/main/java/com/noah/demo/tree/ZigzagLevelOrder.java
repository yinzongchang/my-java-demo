package com.noah.demo.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Title: ZigzagLevelOrder.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 *
 * @author yinzo 2020/11/20
 */
public class ZigzagLevelOrder {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> levelOrderList = new ArrayList<>();

        if (root == null) {

            return levelOrderList;
        }

        Queue<TreeNode> levelNodeQueue = new LinkedList<>();
        levelNodeQueue.offer(root);

        boolean order = true;

        while (!levelNodeQueue.isEmpty()) {


            int size = levelNodeQueue.size();

            List<Integer> levelList = new LinkedList<>();
            for (int i = 0; i < size; i++) {

                TreeNode node = levelNodeQueue.poll();

                if (order) {
                    levelList.add(node.val);
                } else {
                    levelList.add(0, node.val);
                }

                if (node.left != null) {
                    levelNodeQueue.offer(node.left);
                }
                if (node.right != null) {
                    levelNodeQueue.offer(node.right);
                }
            }

            levelOrderList.add(levelList);
            order = !order;
        }
        return levelOrderList;
    }
}

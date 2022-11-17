package com.noah.demo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Title: HelloWorld.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 *
 * @author yinzo 2020/10/10
 */
public class HelloWorld {

    public static void main(String[] args) {


        System.out.println("hehe");
    }

    //  Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {

        int result = 0;
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> levelQueue = new LinkedList<>();
        levelQueue.offer(root);

        while (!levelQueue.isEmpty()) {

            int size = levelQueue.size();
            for (int i = 0; i < size; i++) {

                TreeNode node = levelQueue.poll();
                if (node.left != null) {
                    levelQueue.offer(node.left);
                }
                if (node.right != null) {
                    levelQueue.offer(node.right);
                }
            }

            result++;

        }

        return result;
    }

}

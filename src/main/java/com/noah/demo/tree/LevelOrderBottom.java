package com.noah.demo.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Title: LevelOrderBottom.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 *
 * @author yinzo 2020/11/20
 */
public class LevelOrderBottom {


    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        // 定义最外层集合
        List<List<Integer>> levelOrderList = new LinkedList<>();

        if (root == null) {

            return levelOrderList;
        }

        Queue<TreeNode> levelNodeQueue = new LinkedList<>();
        levelNodeQueue.offer(root);

        while (!levelNodeQueue.isEmpty()) {

            int levelSize = levelNodeQueue.size();

            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {

                TreeNode node = levelNodeQueue.poll();
                levelList.add(node.val);

                if (node.left != null) {
                    levelNodeQueue.offer(node.left);
                }
                if (node.right != null) {
                    levelNodeQueue.offer(node.right);
                }
            }

            levelOrderList.add(0, levelList);
        }

        return levelOrderList;
    }


}

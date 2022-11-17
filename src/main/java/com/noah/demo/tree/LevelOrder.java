package com.noah.demo.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Title: LevelOrder.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 *
 * @author yinzo 2020/11/18
 */
public class LevelOrder {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {


        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }


        Queue<TreeNode> levelNode = new LinkedList<>();
        levelNode.offer(root);

        while (!levelNode.isEmpty()) {

            int levelSize = levelNode.size();

            List<Integer> levelList = new ArrayList<>();

            result.add(levelList);

            for (int i = 0; i < levelSize; i++) {

                TreeNode treeNode = levelNode.poll();
                levelList.add(treeNode.val);

                if (treeNode.left != null) {
                    levelNode.offer(treeNode.left);
                }

                if (treeNode.right != null) {
                    levelNode.offer(treeNode.right);
                }

            }


        }

        return result;
    }

}

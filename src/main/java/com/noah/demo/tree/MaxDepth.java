package com.noah.demo.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Title: MaxDepth.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 *
 * @author yinzo 2020/11/20
 */
public class MaxDepth {


    public static int solution(LevelOrder.TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = solution(root.left);
        int right = solution(root.right);

        return Math.max(left, right) + 1;
    }

    public static int solution2(LevelOrder.TreeNode root) {

        if (root == null) {
            return 0;
        }

        int result = 0;
        Queue<LevelOrder.TreeNode> levelQueue = new LinkedList<>();
        levelQueue.offer(root);

        while (!levelQueue.isEmpty()) {

            int size = levelQueue.size();

            for (int i = 0; i < size; i++) {

                LevelOrder.TreeNode node = levelQueue.poll();

                if (node.left != null) {
                    levelQueue.offer(node.left);
                }

                if (node.right != null) {
                    levelQueue.offer(node.right);
                }

                result++;
            }
        }

        return result;
    }

}

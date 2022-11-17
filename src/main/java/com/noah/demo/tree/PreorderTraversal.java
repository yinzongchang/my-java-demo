package com.noah.demo.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Title: PreorderTraversal.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2020/11/22
 */
public class PreorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public static List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        preorder(root, result);

        return result;
    }

    public static void preorder(TreeNode root, List<Integer> res) {

        if (root == null) {

            return;
        }

        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }


    public static List<Integer> preorderTraversal2(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        TreeNode node = root;

        Deque<TreeNode> stack = new LinkedList<>();

        while (!stack.isEmpty() || node != null) {

            while (node != null) {

                result.add(node.val);
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            node = node.right;

        }

        return result;
    }


}

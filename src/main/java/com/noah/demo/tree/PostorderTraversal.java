package com.noah.demo.tree;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Title: PostorderTraversal.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2020/11/22
 */
public class PostorderTraversal {

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

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        postorder(root, res);
        return res;
    }

    public static void postorder(TreeNode root, List<Integer> result) {

        if (root == null) {
            return;
        }

        postorder(root.left, result);
        postorder(root.right, result);
        result.add(root.val);
    }


    public List<Integer> postorderTraversal2(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        Deque<TreeNode> stack = new LinkedList<>();

        TreeNode node = root;

        TreeNode prev = null;

        while (!stack.isEmpty() || node != null) {

            while (node != null) {

                stack.push(node);
                node = node.left;
            }

            node = stack.pop();

            if (node.right == null || node.right == prev) {

                result.add(root.val);
                prev = root;
                root = null;
            } else {

                stack.push(node);
                node = node.right;
            }
        }

        return result;
    }

}

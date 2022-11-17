package com.noah.demo.tree;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {


    /**
     * 中序遍历
     * 左->根->右
     */
    public List<Integer> inorderTraversal(TreeNode treeNode) {

        List<Integer> result = new ArrayList<Integer>();

        inorder(treeNode, result);

        return result;
    }

    public void inorder(TreeNode root, List<Integer> result) {

        if (root == null) {
            return;
        }

        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }


    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(new InorderTraversal().inorderTraversal(root).toString());

    }



    // Definition for a binary tree node.
    public static class TreeNode {
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



}

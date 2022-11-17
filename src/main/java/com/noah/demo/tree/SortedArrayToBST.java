package com.noah.demo.tree;

/**
 * Title: SortedArrayToBST.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 *
 * @author yinzo 2020/11/22
 */
public class SortedArrayToBST {

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

    public TreeNode sortedArrayToBST(int[] nums) {

        return helper(nums, 0, nums.length - 1);

    }

    public static TreeNode helper(int[] num, int left, int right) {

        if (left > right) {
            return null;
        }

        // 总是选择中间位置左边数字作为根节点
        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(num[mid]);
        root.left = helper(num, left, mid - 1);
        root.right = helper(num, mid + 1, right);

        return root;
    }


}

package com.noah.demo.list;

import java.util.Arrays;

public class MergeTwoArrays {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;

        while (p1 >= 0 && p2 >= 0) {

            if (nums1[p1] < nums2[p2]) {
                nums1[p] = nums2[p2];
                p2--;
            } else {
                nums1[p] = nums1[p1];
                p1--;
            }

            p--;
        }

        // add missing elements from nums2
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);

        while (p2 >= 0) {

            nums1[p2] = nums2[p2];
            p2--;
        }

    }


    public static void main(String[] args) {

        int[] arr = {1, 2};

        int index = 1;

        arr[index--] = 3;

        System.out.println(Arrays.toString(arr));

    }

}

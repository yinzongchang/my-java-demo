package com.noah.demo;

/**
 * Title: MaxArea.java <br>
 * Description: 最大盛水量 <br>
 * Copyright: Copyright (c) 2015<br>
 *
 * @author yinzo 2020/11/18
 */
public class MaxArea {


    public static void main(String[] args) {

        int[] a = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.println(new MaxArea().maxArea2(a));


    }


    /**
     * 双指针，由两端往中间靠拢
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {

        if (height == null || height.length < 1) {
            return 0;
        }

        int i = 0;
        int j = height.length - 1;

        int result = 0;

        while (i < j) {

            int area = (j - i) * Math.min(height[i], height[j]);
            result = Math.max(result, area);

            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }

        return result;
    }

    public int maxArea2(int[] height) {

        if (height == null || height.length < 1) {
            return 0;
        }

        int i = 0;
        int j = height.length - 1;

        int result = 0;

        while (i < j) {

            int area = (j - i) * Math.min(height[i], height[j]);
            result = Math.max(result, area);

            if (height[i] > height[j]) {
                j--;
                while (i < j && height[j] < height[j + 1]) {
                    j--;
                }

            } else {
                i++;

                while (i < j && height[i - 1] > height[i]) {
                    i++;
                }


            }
        }

        return result;
    }

}

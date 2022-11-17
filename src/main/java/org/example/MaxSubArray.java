package org.example;

/**
 * Title: MaxSubArray.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2020/12/10
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {

        if (nums == null || nums.length < 1) {
            return 0;
        }

        int result = nums[0];
        int sum = 0;

        for (int num : nums) {

            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }

            result = Math.max(result, sum);
        }

        return result;
    }

}

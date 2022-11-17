package com.noah.demo.dp;

/**
 * Title: ClimbStairs.java <br>
 * Description:             <br>
 *
 * @author yinzo 2020/12/4
 */
public class ClimbStairs {

    /**
     * f(x) 表示爬到第 xx 级台阶的方案数，考虑最后一步可能跨了一级台阶，也可能跨了两级台阶，所以我们可以列出如下式子：
     * <p>
     * f(x) = f(x - 1) + f(x - 2)
     * f(x)=f(x−1)+f(x−2)
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {

        if (n <= 0) {
            return 0;
        }

        /**
         * 初始值，c为第1级台阶
         */
        int a = 0;
        int b = 0;
        int c = 1;

        for (int i = 1; i <= n; i++) {

            a = b;
            b = c;
            c = a + b;
        }

        return c;
    }


}

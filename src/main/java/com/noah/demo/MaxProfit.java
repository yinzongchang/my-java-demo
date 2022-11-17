package com.noah.demo;

public class MaxProfit {

    public int maxProfit(int[] prices) {

        // 最大利润
        int maxProfit = 0;

        if (prices == null || prices.length <= 0) {
            return maxProfit;
        }

        // 最小价格
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {

            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice >maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;
    }

}

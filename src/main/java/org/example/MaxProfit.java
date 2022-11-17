package org.example;

/**
 * Title: MaxProfit.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 */
public class MaxProfit {


    public int maxProfit(int[] prices) {


        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        if (prices == null || prices.length < 1) {
            return maxProfit;
        }

        for (int price : prices) {

            if (price < minPrice) {

                minPrice = price;
                continue;
            }

            if (price - minPrice > maxProfit) {

                maxProfit = price - minPrice;
            }

        }

        return maxProfit;
    }


}

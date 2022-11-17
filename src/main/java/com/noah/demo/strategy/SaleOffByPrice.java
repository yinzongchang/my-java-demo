package com.noah.demo.strategy;

import java.math.BigDecimal;

/**
 * Title: SaleOffByPrice.java <br>
 * Description: 满足金额 price 减金额 salePrice <br>
 *
 * @author yinzo 2020/11/1
 */
public class SaleOffByPrice implements DiscountCalculation {

    /**
     * 满足金额
     */
    private final BigDecimal price;

    /**
     * 满减金额
     */
    private final BigDecimal salePrice;


    public SaleOffByPrice(BigDecimal price, BigDecimal salePrice) {

        this.price = price;
        this.salePrice = salePrice;
    }

    /**
     * 计算折扣价格
     *
     * @param order
     * @return
     */
    @Override
    public void calculationDiscount(Order order) {

        if (order.getPrice().compareTo(price) >= 0) {

            BigDecimal newPrice = order.getFinalPrice().subtract(salePrice);

            if (newPrice.compareTo(BigDecimal.ZERO) < 0) {

                order.setFinalPrice(BigDecimal.ZERO);
                return;
            }

            order.setFinalPrice(newPrice);
        }
    }
}

package com.noah.demo.strategy;

import java.math.BigDecimal;

/**
 * Title: SaleOffByNumber.java <br>
 * Description: 按数量进行满减 <br>
 *
 * @author yinzo 2020/11/1
 */
public class SaleOffByNumber implements DiscountCalculation {

    /**
     * 满足件数
     */
    private final int number;

    /**
     * 优惠金额
     */
    private final BigDecimal salePrice;

    public SaleOffByNumber(int number, BigDecimal salePrice) {

        this.number = number;
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

        if (order.getNumber() >= number) {

            BigDecimal newPrice = order.getFinalPrice().subtract(salePrice);

            if (newPrice.compareTo(BigDecimal.ZERO) < 0) {

                order.setFinalPrice(BigDecimal.ZERO);
                return;
            }

            order.setFinalPrice(newPrice);
        }
    }

}

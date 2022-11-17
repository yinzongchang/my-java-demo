package com.noah.demo.strategy;

import java.math.BigDecimal;

/**
 * Title: DiscountCalculation.java <br>
 * Description: 满减规则定义 <br>
 *
 * @author yinzo 2020/11/1
 */
public interface DiscountCalculation {


    /**
     * 计算折扣价格
     *
     * @param order
     * @return
     */
    void calculationDiscount(Order order);

}

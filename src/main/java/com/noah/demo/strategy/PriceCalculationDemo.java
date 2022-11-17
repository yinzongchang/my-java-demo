package com.noah.demo.strategy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Title: Price.java <br>
 * Description:             <br>
 *
 * @author yinzo 2020/11/1
 */
public class PriceCalculationDemo {


    /**
     * 满减优惠价格计算角色PriceCalculation，不同的角色自定义策略组合。
     * DiscountCalculation 为 Strategy 接口，定义了满减规则。
     * SaleOffByNumber、SaleOffByPrice 实现 Strategy 接口，是两种优惠策略的例子。
     *
     * 涉及扩展点：
     * 1. 满减规则可以同通过 DiscountCalculation Strategy 接口 进行扩展。
     * 2. 多种满减策略组合，通过PriceCalculation 进行组合。（只实现了互不影响的策略组合，现实中还会有策略相互影响的策略组合）
     */
    public static void main(String[] args) {

        // 定义策略信息
        final List<DiscountCalculation> list = new ArrayList<>();
        DiscountCalculation calculation1 = new SaleOffByNumber(5, new BigDecimal("20"));
        DiscountCalculation calculation2 = new SaleOffByPrice(new BigDecimal("500"), new BigDecimal("50"));
        list.add(calculation1);
        list.add(calculation2);

        // 初始化订单信息
        Order order = new Order(5, new BigDecimal("1000"));

        PriceCalculation calculation = new PriceCalculation(order, list);

        // 计算订单价格
        calculation.orderPrice();

        System.out.println(order.getFinalPrice());
    }


}

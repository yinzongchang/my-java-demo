package com.noah.demo.strategy;

import java.util.List;

/**
 * Title: PriceCalculation.java <br>
 * Description:   价格计算 <br>
 *
 * @author yinzo 2020/11/1
 */
public class PriceCalculation {

    /**
     * 订单信息
     */
    private Order order;

    /**
     * 满减策略组合
     */
    private List<DiscountCalculation> discountCalculationList;

    public PriceCalculation(Order order, List<DiscountCalculation> discountCalculationList) {

        this.order = order;
        this.discountCalculationList = discountCalculationList;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<DiscountCalculation> getDiscountCalculationList() {
        return discountCalculationList;
    }

    public void setDiscountCalculationList(List<DiscountCalculation> discountCalculationList) {
        this.discountCalculationList = discountCalculationList;
    }

    /**
     * 计算订单金额
     */
    public void orderPrice() {

        if (discountCalculationList == null || discountCalculationList.size() <= 0) {
            return;
        }

        for (DiscountCalculation calculation : discountCalculationList) {
            calculation.calculationDiscount(order);
        }

    }

}

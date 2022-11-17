package com.noah.demo.strategy;

import java.math.BigDecimal;

/**
 * Title: Order.java <br>
 * Description:  简易订单信息主体 <br>
 *
 * @author yinzo 2020/11/1
 */
public class Order {

    /**
     * 商品件数
     */
    private Integer number;

    /**
     * 总价
     */
    private BigDecimal price;

    /**
     * 最终价格
     */
    private BigDecimal finalPrice;

    public Order(Integer number, BigDecimal price) {

        this.number = number;
        this.price = price;
        this.finalPrice = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(BigDecimal finalPrice) {
        this.finalPrice = finalPrice;
    }
}

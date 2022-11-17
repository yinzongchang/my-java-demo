package org.example.test.math;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * TestDecimal.java
 *
 * @author yinzongchang
 * 创建时间 2022/11/3
 * @since 1.0
 */
public class TestDecimal {

    @Test
    public void testBigDecimal() {

        BigDecimal b1 = new BigDecimal("1.0000");
        System.out.println(b1.toString());


        System.out.println(Integer.valueOf(b1.toString()));


    }

}

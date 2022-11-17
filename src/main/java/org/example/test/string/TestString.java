package org.example.test.string;

import org.junit.Test;

import java.util.Date;

/**
 * TestString.java
 *
 * @author yinzongchang
 * 创建时间 2022/10/31
 * @since 1.0
 */
public class TestString {

    @Test
    public void testFormat() {

        Date date = null;

        System.out.println(String.format("%s-%s", date, "haha"));


    }

}

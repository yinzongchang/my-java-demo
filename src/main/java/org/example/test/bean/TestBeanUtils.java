package org.example.test.bean;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * TestBeanUtils.java
 *
 * @author yinzongchang
 * 创建时间 2022/10/31
 * @since 1.0
 
 */
public class TestBeanUtils {

    @Test
    public void testCopy() {

        BeanA beanA = new BeanA();
        beanA.setDate(0L);

        BeanB beanB = new BeanB();

        BeanUtils.copyProperties(beanA, beanB);

        System.out.println(JSONObject.toJSONString(beanB));

        System.out.println(new Date(1667145600000L));
    }


}

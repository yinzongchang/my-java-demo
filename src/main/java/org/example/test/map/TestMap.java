package org.example.test.map;

import java.util.HashMap;
import java.util.Map;

/**
 * TestMap.java
 *
 * @author yinzongchang
 * 创建时间 2022/11/7
 * @since 1.0
 */
public class TestMap {



    Map<String, Object> map = new HashMap<>();


    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();

        System.out.println((String) map.get("1"));
    }

}

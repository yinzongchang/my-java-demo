package org.example.test.nullable;

import javax.validation.constraints.NotNull;

/**
 * TestNullable.java
 *
 * @author yinzongchang
 * 创建时间 2022/10/24
 * @since 1.0
 */
public class TestNullable {

    public static void print(@NotNull String string) {

        System.out.println(string);
    }

    public static void main(String[] args) {

        print(null);
    }

}

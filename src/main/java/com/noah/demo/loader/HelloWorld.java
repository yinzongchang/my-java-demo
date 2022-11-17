package com.noah.demo.loader;

import java.util.Arrays;

/**
 * Title: HelloWorld.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 *
 * @author yinzo 2020/10/13
 */
public class HelloWorld implements IHelloWorld {

    static {
        System.out.println("Hello world class is initialized.");
    }

    public String welcome() {

        return "Hello World";
    }

    public static void main(String[] args) {


        System.out.println(Arrays.toString(HelloWorld.class.getInterfaces()));

    }

}

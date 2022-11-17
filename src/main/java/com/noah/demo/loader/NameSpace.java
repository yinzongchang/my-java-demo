package com.noah.demo.loader;


/**
 * Title: NameSpace.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 *
 * @author yinzo 2020/10/14
 */
public class NameSpace {

    public static void main(String[] args) throws ClassNotFoundException {


//        ClassLoader classLoader = NameSpace.class.getClassLoader();
//
//        Class<?> aClass = classLoader.loadClass("com.noah.demo.loader.HelloWorld");
//        Class<?> bClass = classLoader.loadClass("com.noah.demo.loader.HelloWorld");
//
//        System.out.println(aClass.hashCode());
//        System.out.println(bClass.hashCode());
//        System.out.println(aClass == bClass);
//

        /**
         * 不同类加载器加载同一个class
         */
//        MyClassLoader classLoader1 = new MyClassLoader("/Users/yinzongchang/classloader", null);
//        BrokerDelegateClassLoader classLoader2 = new BrokerDelegateClassLoader("/Users/yinzongchang/classloader", null);
//
//        Class<?> aClass = classLoader1.loadClass("com.noah.demo.loader.HelloWorld");
//        Class<?> bClass = classLoader2.loadClass("com.noah.demo.loader.HelloWorld");
//
//        System.out.println(aClass.getClassLoader());
//        System.out.println(bClass.getClassLoader());
//
//        System.out.println(aClass.hashCode());
//        System.out.println(bClass.hashCode());
//        System.out.println(aClass == bClass);


        /**
         * 相同类加载器加载同一个class
         * 同一个class实例在同一个类加载器命名空间之下是唯一的
         */

        MyClassLoader classLoader1 = new MyClassLoader("/Users/yinzongchang/classloader", null);
        MyClassLoader classLoader2 = new MyClassLoader("/Users/yinzongchang/classloader", null);

        Class<?> aClass = classLoader1.loadClass("com.noah.demo.loader.HelloWorld");
        Class<?> bClass = classLoader2.loadClass("com.noah.demo.loader.HelloWorld");

        System.out.println(aClass.getClassLoader());
        System.out.println(bClass.getClassLoader());

        System.out.println(aClass.hashCode());
        System.out.println(bClass.hashCode());
        System.out.println(aClass == bClass);
    }

}

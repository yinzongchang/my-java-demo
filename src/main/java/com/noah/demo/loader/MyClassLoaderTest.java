package com.noah.demo.loader;

import java.lang.reflect.InvocationTargetException;

/**
 * Title: MyClassLoaderTest.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 *
 * @author yinzo 2020/10/13
 */
public class MyClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

//        // 声明类加载器
//        MyClassLoader myClassLoader = new MyClassLoader();
//
//        // 使用myClassLoader 加载HelloWorld
//        Class<?> aClass = myClassLoader.loadClass("com.noah.demo.loader.HelloWorld");
//
//        System.out.println("myClassLoader的父加载器:" + myClassLoader.getParent());
//
//        System.out.println("aClass 的类加载器: " + aClass.getClassLoader());
//
//        System.out.println("线程上下文类加载器: " + Thread.currentThread().getContextClassLoader());

//        // 1.注释
//        Object helloWorld = aClass.newInstance();
//        System.out.println(helloWorld);
//        System.out.println(helloWorld.getClass().getName());
//        System.out.println(helloWorld.hashCode());
//
//
//        Method welcomeMethod = aClass.getMethod("welcome");
//        String result = (String) welcomeMethod.invoke(helloWorld);
//        System.out.println("Result:" + result);


        /**
         * 绕过系统类加载器，直接将扩展累加载器作为MyClassLoader的父加载器
         */
//        ClassLoader extClassLoader = MyClassLoaderTest.class.getClassLoader().getParent();
//
//        MyClassLoader myClassLoader = new MyClassLoader("/Users/yinzongchang/classloader", extClassLoader);
//
//        // 使用myClassLoader 加载HelloWorld
//        Class<?> aClass = myClassLoader.loadClass("com.noah.demo.loader.HelloWorld");
//
//        System.out.println("aClass 的类加载器: " + aClass.getClassLoader());
//        System.out.println("线程上下文类加载器: " + Thread.currentThread().getContextClassLoader());

        /**
         * 方法二，在构建MyClassLoader的时候指定其父类加载器为null
         */
        MyClassLoader myClassLoader = new MyClassLoader("/Users/yinzongchang/classloader", null);
        // 使用myClassLoader 加载HelloWorld
        Class<?> aClass = myClassLoader.loadClass("com.noah.demo.loader.HelloWorld");

        System.out.println("aClass 的类加载器: " + aClass.getClassLoader());
        System.out.println("线程上下文类加载器: " + Thread.currentThread().getContextClassLoader());


    }

}

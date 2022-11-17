package com.noah.demo.loader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Title: MyClassLoader.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 *
 * @author yinzo 2020/10/10
 */
// 自定义类加载器必须是ClassLoader的直接或者间接子类
public class MyClassLoader extends ClassLoader {


    // 定义默认的class存放路径
    private static final Path DEFAULT_CLASS_DIR = Paths.get("/Users/yinzongchang", "classloader");

    private final Path classDir;

    public MyClassLoader() {
        super();
        this.classDir = DEFAULT_CLASS_DIR;
    }

    public MyClassLoader(String classDir) {

        super();
        this.classDir = Paths.get(classDir);
    }

    public MyClassLoader(String classDir, ClassLoader parentClassLoader) {

        super(parentClassLoader);
        this.classDir = Paths.get(classDir);
    }

    // 重写父类的findClass
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        // 读取class的二进制数据
        byte[] classBytes = this.readClassBytes(name);
        if (classBytes.length == 0) {

            throw new ClassNotFoundException("Can not load the class " + name);
        }

        // 调用defineClass 方法定义class
        return this.defineClass(name, classBytes, 0, classBytes.length);
    }


    @Override
    public String toString() {

        return "My ClassLoader";
    }

    private byte[] readClassBytes(String name) throws ClassNotFoundException {

        // 将包名分隔符转换为文件路径分隔符号
        String classPath = name.replace(".", "/");

        Path classFullPath = classDir.resolve(Paths.get(classPath + ".class"));

        if (!classFullPath.toFile().exists()) {
            throw new ClassNotFoundException("The class " + name + " not found.");
        }

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            Files.copy(classFullPath, baos);
            return baos.toByteArray();
        } catch (IOException e) {
            throw new ClassNotFoundException("load the class " + name + " occur error.", e);
        }


    }

    public static void main(String[] args) {

    }
}

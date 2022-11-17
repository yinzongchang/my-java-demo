package com.noah.demo.loader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Title: BrokerDelegateClassLoader.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2020/10/14
 */
public class BrokerDelegateClassLoader extends ClassLoader {

    // 定义默认的class存放路径
    private static final Path DEFAULT_CLASS_DIR = Paths.get("/Users/yinzongchang", "classloader");

    private final Path classDir;

    public BrokerDelegateClassLoader() {
        super();
        this.classDir = DEFAULT_CLASS_DIR;
    }

    public BrokerDelegateClassLoader(String classDir) {

        super();
        this.classDir = Paths.get(classDir);
    }

    public BrokerDelegateClassLoader(String classDir, ClassLoader parentClassLoader) {

        super(parentClassLoader);
        this.classDir = Paths.get(classDir);
    }


    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {

        // 1.
        synchronized (getClassLoadingLock(name)) {

            // 2
            Class<?> klass = findLoadedClass(name);

            // 3
            if (klass == null) {

                // 4.
                if (name.startsWith("java.") || name.startsWith("javax")) {

                    try {
                        klass = getSystemClassLoader().loadClass(name);
                    } catch (Exception e) {

                        // ignore
                    }

                } else {

                    // 5
                    try {
                        klass = this.findClass(name);
                    } catch (Exception e) {
                        // ignore
                    }

                    // 6
                    if (klass == null) {

                        if (getParent() != null) {

                            klass = getParent().loadClass(name);
                        } else {

                            klass = getSystemClassLoader().loadClass(name);
                        }
                    }

                }
            }

            // 7
            if (null == klass) {

                throw new ClassNotFoundException("The class " + name + " not found.");
            }

            if (resolve) {

                resolveClass(klass);
            }

            return klass;
        }

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

        return "BrokerDelegate ClassLoader";
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

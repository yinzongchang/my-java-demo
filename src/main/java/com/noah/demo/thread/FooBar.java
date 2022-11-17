package com.noah.demo.thread;

/**
 * Title: FooBar.java <br>
 * Description:             <br>
 * Copyright: Copyright (c) 2015<br>
 * Company: 北京云杉世界信息技术有限公司<br>
 *
 * @author yinzo 2020/11/30
 */
public class FooBar {

    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    private boolean fooFlag = true;
    private boolean barFlag = false;

    final Object lock = new Object();


    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            synchronized (lock) {

                while (!fooFlag) {
                    lock.wait();
                }


                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();

                fooFlag = false;
                barFlag = true;
                lock.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            synchronized (lock) {

                while (!barFlag) {
                    lock.wait();
                }

                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();

                barFlag = false;
                fooFlag = true;
                lock.notifyAll();
            }
        }
    }


    public static void main(String[] args) {

        final Runnable runnable1 = new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("foo");
            }
        };

        final Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("bar");
            }
        };


        final FooBar fooBar = new FooBar(100);

        Thread thread1 = new Thread() {

            @Override
            public void run() {
                try {
                    fooBar.foo(runnable1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread2 = new Thread() {

            @Override
            public void run() {
                try {
                    fooBar.bar(runnable2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        thread1.start();
        thread2.start();

    }


}

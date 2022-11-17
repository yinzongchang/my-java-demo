package com.noah.demo.limit;

public class Counter {

    private long timeStamp = System.currentTimeMillis();

    public int reqCount = 0;

    public final int limit = 100; // 时间窗口内允许的最大限制数

    public final long interval = 1000; // 时间窗口ms

    public boolean grant() {

        long now = System.currentTimeMillis();

        if (now < timeStamp + interval) {
            // 在时间窗口内
            reqCount++;
            return reqCount <= limit;
        } else {
            timeStamp = now;
            reqCount = 1;
            return true;
        }


    }

}

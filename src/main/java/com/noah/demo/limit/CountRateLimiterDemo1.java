package com.noah.demo.limit;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class CountRateLimiterDemo1 {

    private static AtomicInteger count = new AtomicInteger(0);

    public static boolean exec() {

        if (count.get() > 5) {
//            System.out.println("用户过多");
            return false;
        } else {
            count.incrementAndGet();
            try {
                //处理核心逻辑
                TimeUnit.SECONDS.sleep(1);
                System.out.println("--" + System.currentTimeMillis() / 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                count.decrementAndGet();
            }
        }

        return true;
    }

}

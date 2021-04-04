package com.lining.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lining
 * 比较并交换
 */
public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        /**
         * true 与预期值相同 赋值
         */
        atomicInteger.compareAndSet(5, 2019);
        /**
         * false 与预期值不同  不赋值
         */
        atomicInteger.compareAndSet(5, 2019);
    }
}

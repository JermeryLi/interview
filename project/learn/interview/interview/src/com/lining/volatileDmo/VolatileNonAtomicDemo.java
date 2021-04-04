package com.lining.volatileDmo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lining
 * volatile非原子性验证
 */
public class VolatileNonAtomicDemo {
    public static void main(String[] args) {
        MyData2 myData2 = new MyData2();
        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 1000; j++) {
                    myData2.addPlusPlus();
                    myData2.addAtomic();
                }
            }, String.valueOf(i)).start();
        }
        //等待20个线程全部计算完成
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + "\t final number value:" + myData2.number);
        System.out.println(Thread.currentThread().getName() + "\t final number value:" + myData2.atomicInteger);
    }
}

class MyData2 {
    volatile int number = 0;
    AtomicInteger atomicInteger = new AtomicInteger();
    public   void addPlusPlus() {
        this.number++;
    }

    public void addAtomic(){
        this.atomicInteger.getAndIncrement();
    }
}
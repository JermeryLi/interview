package com.lining.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lining
 * @date 2021/4/5 10:49
 */
public class LockDemo {
    volatile int n = 0;
    public void add(){
        n++;
    }

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
    }
}

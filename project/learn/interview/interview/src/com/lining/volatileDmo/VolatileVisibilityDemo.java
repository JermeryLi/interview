package com.lining.volatileDmo;

import java.util.concurrent.TimeUnit;

/**
 * @author lining
 * 验证volatile的可见性
 *  变量number 加或不加volatile关键
 *  1、没有加volatile关键字  while循环一直没有结束。主线程没有感知到数据已经被修改。
 *  2、加volatile关键字 跳出循环
 */
public class VolatileVisibilityDemo {
    public static void main(String[] args) {
        MyData myData = new MyData();
        new Thread(() ->{
            System.out.println(Thread.currentThread().getName()+ "\t come in");
            //暂停
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addTo60();
            System.out.println(Thread.currentThread().getName()+ "\t updated number value:" + myData.number);
        }, "AAA").start();

        while(myData.number == 0){

        }

        System.out.println(Thread.currentThread().getName() + "\t mission is over, main get number：" + myData.number);
    }
}

class MyData{
    volatile int number = 0;
    public void addTo60(){
        this.number = 60;
    }
}
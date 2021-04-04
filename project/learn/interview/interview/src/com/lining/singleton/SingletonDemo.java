package com.lining.singleton;

/**
 * @author lining
 * 单例模式 在多线程下会出现的问题
 */
public class SingletonDemo {
    //禁止指令重排
    private static volatile SingletonDemo instance = null;

    private SingletonDemo() {
        System.out.println(Thread.currentThread().getName() + "\t 我是构造方法SingletonDemo()");
    }


    //DCL double check lock 双端检查模式
    //synchronized 太重
//    public static SingletonDemo getInstance() {
//        if (instance == null) {
//            instance = new SingletonDemo();
//        }
//        return instance;
//    }
    public static SingletonDemo getInstance(){
        if(instance == null){
            synchronized (SingletonDemo.class){
                if(instance == null){
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        //在多线程的情况下 构造方法会执行多次构造方法
        for (int i = 0; i < 10; i++) {
            new Thread(() ->{
                SingletonDemo.getInstance();
            },String.valueOf(i)).start();
        }
    }
}

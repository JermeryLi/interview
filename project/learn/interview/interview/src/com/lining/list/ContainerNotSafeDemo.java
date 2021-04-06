package com.lining.list;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author lining
 * @date 2021/4/4 17:52
 * 集合线程不安全问题
 */
public class ContainerNotSafeDemo {
    public static void main(String[] args) {
        //用Vector可以解决 其add方法加了锁
        // ArrayList since1.2
        //Vector since1.1 可以说Vector被淘汰了 性能比较差
        List<String> list = new CopyOnWriteArrayList<>();
        List<String> list2 = Collections.synchronizedList(new ArrayList<>());
        for (int i = 1; i <= 3; i++) {
            new Thread(() -> {
                //ConcurrentModificationException 下一行代码会有这个异常
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }

    }
}

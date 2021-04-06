package com.lining.lock;

import java.util.concurrent.CountDownLatch;

/**
 * @author lining
 * @date 2021/4/5 16:07
 */
public class CountDownLatchDemo {
    private static final int COUNT = 6;

    public static void main(String[] args) {

    }

    public static void closeDoor() {
        CountDownLatch countDownLatch = new CountDownLatch(COUNT);
        for (int i = 1; i <= COUNT; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 上完自习，离开教室");
                countDownLatch.countDown();
            }).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "\t 班长关门走人");
    }
}

enum CountryEnum {

    ONE(1, "齐"),
    TWO(2, "楚"),
    THREE(3, "燕"),
    FOUR(4, "赵"),
    FIVE(5, "魏"),
    SIX(6, "韩");

    private Integer retCode;
    private String retMessage;

    CountryEnum(Integer retCode, String retMessage) {
        this.retCode = retCode;
        this.retMessage = retMessage;
    }

    public String getRetMessage() {
        return retMessage;
    }

    public Integer getRetCode() {
        return retCode;
    }

    public static CountryEnum foreachCountryEnum(int index) {
        CountryEnum[] myArray = CountryEnum.values();
        for (CountryEnum countryEnum : myArray) {
            if (index == countryEnum.getRetCode()) {
                return countryEnum;
            }
        }
        return null;
    }
}
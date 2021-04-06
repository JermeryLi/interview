package com.lining.another;

import lombok.Data;

/**
 * @author lining
 * @date 2021/4/5 10:34
 * 小练习
 */
public class TestTransferValue {
    public void changeValue1(int age){
        age = 30;
    }
    public void changeValue2(Person person){
        person.setName("xxx");
    }

    public void changeValue3(String str){
        str = "xxx";
    }

    public static void main(String[] args) {
        TestTransferValue test = new TestTransferValue();
        int age = 20;
        test.changeValue1(age);
        System.out.println("age---" + age);

        Person person = new Person();
        test.changeValue2(person);
        System.out.println("personName:----" + person.getName());

        String str = "abc";
        test.changeValue3(str);
        System.out.println("String---" + str);
    }
}
@Data
class Person{
    int age;
    String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
package com.ligw.renld;

/**
 * @author created by ligw on 2022/8/22
 * @Email ligw@wanbu.com.cn
 */
public class FanShe {
    private String name = "Tom";
    public int age = 0;

    public FanShe() {
    }

    public FanShe(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public void test(String name, int age){
        System.out.println("===========" + name + "   " + age);
    }

}

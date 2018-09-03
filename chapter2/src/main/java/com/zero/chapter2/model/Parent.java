package com.zero.chapter2.model;

/**
 * Created by liyuan on 2018/8/23
 */
public class Parent {
    public Parent() {
        System.out.println("父类构造器");
    }

    static {
        System.out.println("父类静态代码块");
    }
    {
        System.out.println("父类代码块");
    }
}

package com.zero.chapter2.model;

/**
 * Created by liyuan on 2018/8/23
 */
public class Test extends Parent {
    static {
        System.out.println("子类静态代码块");
    }

    {
        System.out.println("子类代码块");
    }

    public Test() {
        System.out.println("子类构造器");
    }

    public static void main(String[] args) {
        Test t1 = new Test();
        System.out.println("-----------华丽的分割线----------");
        Test t2 = new Test();
    }
}

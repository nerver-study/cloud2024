package com.atguigu.designmethods.single;

public class Singleton03 {

    private static final Singleton03 instance = new Singleton03();

    // 私有构造方法
    private Singleton03() {}

    // 全局访问点
    public static Singleton03 getInstance() {
        return instance;
    }
}

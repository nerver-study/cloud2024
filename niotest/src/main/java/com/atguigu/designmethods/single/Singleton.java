package com.atguigu.designmethods.single;

public class Singleton {

    // 私有构造方法
    private Singleton() {}

    // 静态内部类
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    // 全局访问点
    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}

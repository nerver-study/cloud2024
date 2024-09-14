package com.atguigu.designmethods.single;

public class Singleton02 {

    //使用 volatile 关键字确保可见性和有序性。
    private volatile static Singleton02 instance;

    // 私有构造方法
    private Singleton02() {}

    //懒汉式（双重检查锁定）：
    // 双重检查锁定
    public static Singleton02 getInstance() {
        if (instance == null) {
            synchronized (Singleton02.class) {
                if (instance == null) {
                    instance = new Singleton02();
                }
            }
        }
        return instance;
    }
}

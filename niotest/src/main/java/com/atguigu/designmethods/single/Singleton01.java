package com.atguigu.designmethods.single;

public class Singleton01 {
//    懒汉式（线程安全）
    private static Singleton01 instance;

    // 私有构造方法
    private Singleton01() {}

    // 同步方法
    public static synchronized Singleton01 getInstance() {
        if (instance == null) {
            instance = new Singleton01();
        }
        return instance;
    }
}

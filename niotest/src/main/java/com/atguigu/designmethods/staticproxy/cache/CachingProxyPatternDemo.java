package com.atguigu.designmethods.staticproxy.cache;




public class CachingProxyPatternDemo {
    public static void main(String[] args) {
        Subject subject = new CachingProxy();
        subject.request(); // 第一次请求
        subject.request(); // 第二次请求，使用缓存
    }
}

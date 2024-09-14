package com.atguigu.designmethods.staticproxy;


public class ProxyPatternDemo {
    //静态代理，接口有2个实现类，1个真正的实现类，1个代理类代理了那个真正的实现类，也是增强了这个真正的实现类
    //因为已经确定了代理，所以用多态也就增强了
    public static void main(String[] args) {
        Subject subject = new Proxy();
        subject.request();
    }
}

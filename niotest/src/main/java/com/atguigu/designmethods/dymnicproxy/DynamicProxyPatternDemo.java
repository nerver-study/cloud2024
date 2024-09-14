package com.atguigu.designmethods.dymnicproxy;

public class DynamicProxyPatternDemo {
    public static void main(String[] args) {
        //jdk动态代理，是对实现类的增强，接口需要有实现类
        RealSubject realSubject = new RealSubject();
        DynamicProxy dynamicProxy = new DynamicProxy(realSubject);
        Subject subject = (Subject) dynamicProxy.getProxy();//生成一个代理类，在内存中
        subject.request();//代理类去调用这个方法，执行增强方法


//        基于接口：JDK 动态代理要求被代理的对象必须实现至少一个接口。
//        动态生成代理类：在运行时动态生成代理类，并且这个代理类实现了被代理对象实现的所有接口。
//        使用 Proxy 类：通过 Proxy.newProxyInstance() 方法来创建代理对象。
    }
}

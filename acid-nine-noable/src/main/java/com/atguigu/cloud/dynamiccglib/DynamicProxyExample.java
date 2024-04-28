package com.atguigu.cloud.dynamiccglib;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib动态代理
 *
 */
// 实现目标类
class Service {
    public void doSomething() {
        System.out.println("实际的服务对象：执行了doSomething方法");
    }
}

// 实现MethodInterceptor接口来创建代理对象
class ServiceInterceptor implements MethodInterceptor {
    // 在代理对象执行方法之前，需要执行的操作
    public void beforeMethod() {
        System.out.println("代理对象：执行前置操作");
    }

    // 在代理对象执行方法之后，需要执行的操作
    public void afterMethod() {
        System.out.println("代理对象：执行后置操作");
    }

    // 实现MethodInterceptor接口的intercept方法
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        beforeMethod();
        Object result = proxy.invokeSuper(obj, args);
        afterMethod();
        return result;
    }
}

// 使用动态代理
public class DynamicProxyExample {
    public static void main(String[] args) {
        // 创建Enhancer对象
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Service.class);
        enhancer.setCallback((Callback) new ServiceInterceptor());

        // 创建代理对象
        Service proxy = (Service) enhancer.create();

        // 通过代理对象调用方法
        proxy.doSomething();
    }
}

package com.atguigu.cloud.dynamincjdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk动态代理
 */
// 定义一个接口
interface IService {
    void doSomething();
}

// 实现接口的类
class Service implements IService {
    public void doSomething() {
        System.out.println("实际的服务对象：执行了doSomething方法");
    }
}

// 实现InvocationHandler接口来创建代理对象
class ServiceProxy implements InvocationHandler {
    private Object target;

    public ServiceProxy(Object target) {
        this.target = target;
    }

    // 在代理对象执行方法之前，需要执行的操作
    public void beforeMethod() {
        System.out.println("代理对象：执行前置操作");
    }

    // 在代理对象执行方法之后，需要执行的操作
    public void afterMethod() {
        System.out.println("代理对象：执行后置操作");
    }

    // 实现InvocationHandler接口的invoke方法
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        beforeMethod();
        Object result = method.invoke(target, args);
        afterMethod();
        return result;
    }
}

// 使用动态代理
public class DynamicProxyExample {
    public static void main(String[] args) {
        // 创建实际的服务对象
        IService service = new Service();

        // 创建代理对象
        IService proxy = (IService) Proxy.newProxyInstance(IService.class.getClassLoader(),
                new Class<?>[]{IService.class}, new ServiceProxy(service));

        // 通过代理对象调用方法
        proxy.doSomething();
    }
}

package com.atguigu.designmethods.dymnicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
//Invocation 有调用的意思
public class DynamicProxy implements InvocationHandler {
    private Object target;

    public DynamicProxy(Object target) {
        this.target = target;
    }

    // jdk代理和cglib代理：创建代理对象需要传入代理类的加载器，和工具类
    // jdk代理还需多传一个接口类    cglib代理需要多传一个回调类

    //增强方法：
    //  1.jdk代理，cglib代理都需要传入代理类和参数
    //  2.增强的方法有的参数： 代理类，参数，方法     cglib多了一个方法代理

    //MethodProxy methodProxy：用于实际调用目标方法的对象。通常用于代理方法的调用。
    //代理方法调用：MethodProxy 可以用来直接调用目标对象的方法，绕过反射开销。
    //性能优化：相比于普通的 Method.invoke，MethodProxy 提供了一种更快捷的方式来进行方法调用。

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("DynamicProxy is performing pre-request operations.");
        Object result = method.invoke(target, args);
        System.out.println("DynamicProxy is performing post-request operations.");
        return result;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this
        );
    }
}

package com.atguigu.designmethods.cglibproxy;

import com.sun.org.apache.bcel.internal.classfile.Code;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

    private Object target;

    public Object getProxyInstance(Object target) {
        this.target = target;
        // Enhancer类是CGLIB提供的用来创建动态代理类的对象
        Enhancer enhancer = new Enhancer();
        // 设置被代理类
        enhancer.setSuperclass(this.target.getClass());
        // 设置回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }

//    CGLIB的执行流程简述如下：
//    生成子类：CGLIB通过继承目标类的方式创建一个子类，并对这个子类进行增强。
//    方法拦截：当调用增强子类的方法时，CGLIB会将调用转到其内部的拦截器。
//    执行逻辑：拦截器可以在方法调用前后执行自定义逻辑，然后选择是否继续调用原始方法。
//    委托调用：如果决定继续，则通过反射调用原始方法。
//    这一过程实现了对目标类方法的透明代理。

    @Override
    public Object intercept(Object proxy, Method method, Object[] args,
                            MethodProxy methodProxy) throws Throwable {
        System.out.println("方法调用前...");
        Object result = methodProxy.invokeSuper(proxy, args);
//        Object result = method.invoke(proxy, args);//有错

        //原因
        //Method.invoke 需要确保 proxy 对象确实是 method 所属类的实例。
        //如果 proxy 是通过 CGLIB 生成的子类，则直接使用 Method.invoke 可能会导致类型不匹配。
        System.out.println("方法调用后...");
        return result;
    }
}

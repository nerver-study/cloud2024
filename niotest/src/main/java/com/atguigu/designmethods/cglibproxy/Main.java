package com.atguigu.designmethods.cglibproxy;

public class Main {
    public static void main(String[] args) {
        Subject realSubject = new Subject();
        CglibProxy proxy = new CglibProxy();
        Subject subjectProxy = (Subject) proxy.getProxyInstance(realSubject);

        subjectProxy.action();
    }

    //在这个例子中，Subject类没有实现任何接口，这正是CGLIB动态代理的一个优点——它可以为任何类创建代理，
    // 而不仅仅是实现了接口的类。
    // CglibProxy类实现了MethodInterceptor接口，并且在intercept方法中添加了方法调用前后的处理逻辑。
    // 通过Enhancer类创建了一个代理对象，并且设置了回调为CglibProxy实例。
    // 这样，每次通过代理对象调用action方法时，都会先调用intercept方法，在其中可以添加自己的逻辑。
}

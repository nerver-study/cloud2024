package com.atguigu.designmethods.State;

public class Client {
    public static void main(String[] args) {
        // 创建上下文并设置初始状态为灯关闭
        Context context = new Context(new LightOffState());

        // 请求操作
        context.request();  // 输出: 灯已经关闭

        // 更改状态
        context.setState(new LightOnState());

        // 再次请求操作
        context.request();  // 输出: 灯已经打开
    }
}

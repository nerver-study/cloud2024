package com.atguigu.designmethods.State;

public class LightOnState implements State {
    @Override
    public void handle() {
        System.out.println("灯已经打开");
    }
}

 class LightOffState implements State {
    @Override
    public void handle() {
        System.out.println("灯已经关闭");
    }
}

package com.atguigu.designmethods.BridgePattern;

public interface RemoteControl {
    void turnOn();
    void turnOff();
}

 class SimpleRemoteControl implements RemoteControl {
    @Override
    public void turnOn() {
        System.out.println("Simple Remote Control: Turn On");
    }

    @Override
    public void turnOff() {
        System.out.println("Simple Remote Control: Turn Off");
    }
}

 class AdvancedRemoteControl implements RemoteControl {
    @Override
    public void turnOn() {
        System.out.println("Advanced Remote Control: Turn On");
    }

    @Override
    public void turnOff() {
        System.out.println("Advanced Remote Control: Turn Off");
    }
}

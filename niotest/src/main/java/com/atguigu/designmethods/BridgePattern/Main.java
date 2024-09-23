package com.atguigu.designmethods.BridgePattern;

public class Main {
    public static void main(String[] args) {
        // 创建不同的遥控器
        RemoteControl simpleRemote = new SimpleRemoteControl();
        RemoteControl advancedRemote = new AdvancedRemoteControl();

        // 创建不同的设备
        Device tvWithSimpleRemote = new TV(simpleRemote);
        Device radioWithSimpleRemote = new Radio(simpleRemote);

        Device tvWithAdvancedRemote = new TV(advancedRemote);
        Device radioWithAdvancedRemote = new Radio(advancedRemote);

        // 测试不同的组合
        System.out.println("TV with Simple Remote Control:");
        tvWithSimpleRemote.turnOn();
        tvWithSimpleRemote.turnOff();

        System.out.println("\nRadio with Simple Remote Control:");
        radioWithSimpleRemote.turnOn();
        radioWithSimpleRemote.turnOff();

        System.out.println("\nTV with Advanced Remote Control:");
        tvWithAdvancedRemote.turnOn();
        tvWithAdvancedRemote.turnOff();

        System.out.println("\nRadio with Advanced Remote Control:");
        radioWithAdvancedRemote.turnOn();
        radioWithAdvancedRemote.turnOff();
    }
}

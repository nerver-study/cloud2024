package com.atguigu.designmethods.CommandPattern;

public class Main {
    public static void main(String[] args) {
        // 创建接收者对象
        Light light = new Light();

        // 创建具体命令对象
        Command lightOnCommand = new LightOnCommand(light);
        Command lightOffCommand = new LightOffCommand(light);

        // 创建调用者对象
        RemoteControl remoteControl = new RemoteControl();

        // 设置命令并执行
        remoteControl.setCommand(lightOnCommand);
        remoteControl.pressButton(); // 打开灯

        remoteControl.setCommand(lightOffCommand);
        remoteControl.pressButton(); // 关闭灯

        // 撤销操作
        remoteControl.undoPress(); // 重新打开灯
    }
}

package com.atguigu.designmethods.CommandPattern;

public class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }

    public void undoPress() {
        command.undo();
    }
}

package com.atguigu.designmethods.Memento;

public class Main {
    public static void main(String[] args) {
        // 创建发起者
        Originator originator = new Originator();

        // 设置初始状态
        originator.setState("State1");

        // 创建管理者
        Caretaker caretaker = new Caretaker();

        // 保存当前状态

        caretaker.setMemento(originator.saveStateToMemento());

        // 更改状态
        originator.setState("State2");

        // 恢复状态
        originator.getStateFromMemento(caretaker.getMemento());
    }
}

package com.atguigu.designmethods.StrategyPattern;

public class ConcreteStrategyA implements Strategy {
    @Override
    public void execute() {
        System.out.println("Executing strategy A");
    }
}

 class ConcreteStrategyB implements Strategy {
    @Override
    public void execute() {
        System.out.println("Executing strategy B");
    }
}

 class ConcreteStrategyC implements Strategy {
    @Override
    public void execute() {
        System.out.println("Executing strategy C");
    }
}

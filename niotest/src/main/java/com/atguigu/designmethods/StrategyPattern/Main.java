package com.atguigu.designmethods.StrategyPattern;

public class Main {
    public static void main(String[] args) {
        // 创建不同的策略对象
        Strategy strategyA = new ConcreteStrategyA();
        Strategy strategyB = new ConcreteStrategyB();
        Strategy strategyC = new ConcreteStrategyC();

        // 创建上下文对象
        Context context = new Context(strategyA);

        // 使用不同的策略
        System.out.println("Using Strategy A:");
        context.executeStrategy();

        System.out.println("\nUsing Strategy B:");
        context.setStrategy(strategyB);
        context.executeStrategy();

        System.out.println("\nUsing Strategy C:");
        context.setStrategy(strategyC);
        context.executeStrategy();
    }
}

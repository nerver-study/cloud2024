package com.atguigu.designmethods.FlyweightPattern;

public class Main {
    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();

        // 创建享元对象
        Flyweight flyweight1 = factory.getFlyweight("X");
        Flyweight flyweight2 = factory.getFlyweight("Y");
        Flyweight flyweight3 = factory.getFlyweight("X");

        // 使用享元对象
        flyweight1.operation("Client 1 - Extrinsic State 1");
        flyweight2.operation("Client 2 - Extrinsic State 2");
        flyweight3.operation("Client 3 - Extrinsic State 3");
    }
}

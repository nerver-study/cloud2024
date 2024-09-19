package com.atguigu.designmethods.Decorator;

public class BaseCoffee implements Coffee {
    @Override
    public double cost() {
        return 2.0;
    }

    @Override
    public String getDescription() {
        return "Base Coffee";
    }
}
   
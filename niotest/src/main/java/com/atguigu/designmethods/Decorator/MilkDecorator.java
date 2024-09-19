package com.atguigu.designmethods.Decorator;

public class MilkDecorator implements Coffee {
       private Coffee coffee;

       public MilkDecorator(Coffee coffee) {
           this.coffee = coffee;
       }

       @Override
       public double cost() {
           return coffee.cost() + 0.5;
       }

       @Override
       public String getDescription() {
           return coffee.getDescription() + ", Milk";
       }
   }
   
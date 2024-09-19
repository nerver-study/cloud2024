package com.atguigu.designmethods.Decorator;

public class ChocolateDecorator implements Coffee {
       private Coffee coffee;

       public ChocolateDecorator(Coffee coffee) {
           this.coffee = coffee;
       }

       @Override
       public double cost() {
           return coffee.cost() + 1.0;
       }

       @Override
       public String getDescription() {
           return coffee.getDescription() + ", Chocolate";
       }
   }
   
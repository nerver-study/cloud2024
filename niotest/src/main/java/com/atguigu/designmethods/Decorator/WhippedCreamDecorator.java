package com.atguigu.designmethods.Decorator;

public class WhippedCreamDecorator implements Coffee {
       private Coffee coffee;

       public WhippedCreamDecorator(Coffee coffee) {
           this.coffee = coffee;
       }

       @Override
       public double cost() {
           return coffee.cost() + 0.8;
       }

       @Override
       public String getDescription() {
           return coffee.getDescription() + ", Whipped Cream";
       }
   }
   
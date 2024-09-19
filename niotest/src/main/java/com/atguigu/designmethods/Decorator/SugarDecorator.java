package com.atguigu.designmethods.Decorator;

public class SugarDecorator implements Coffee {
       private Coffee coffee;

       public SugarDecorator(Coffee coffee) {
           this.coffee = coffee;
       }

       @Override
       public double cost() {
           return coffee.cost() + 0.3;
       }

       @Override
       public String getDescription() {
           return coffee.getDescription() + ", Sugar";
       }
   }
   
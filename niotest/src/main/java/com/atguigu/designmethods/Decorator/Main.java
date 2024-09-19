package com.atguigu.designmethods.Decorator;

public class Main {
       public static void main(String[] args) {
           // 创建基础咖啡
           Coffee baseCoffee = new BaseCoffee();

           // 添加牛奶
           Coffee milkCoffee = new MilkDecorator(baseCoffee);

           // 添加糖
           Coffee sugarCoffee = new SugarDecorator(milkCoffee);

           // 添加巧克力
           Coffee chocolateCoffee = new ChocolateDecorator(sugarCoffee);

           // 添加奶油
           Coffee whippedCreamCoffee = new WhippedCreamDecorator(chocolateCoffee);

           // 输出结果
           System.out.println(whippedCreamCoffee.getDescription());
           System.out.println("Total Cost: $" + whippedCreamCoffee.cost());
       }
   }
   
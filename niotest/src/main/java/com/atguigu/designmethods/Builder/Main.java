package com.atguigu.designmethods.Builder;

public class Main {
       public static void main(String[] args) {
           // 创建具体的建造者
           ComputerBuilder builder = new ConcreteBuilder();

           // 创建导演类
           Director director = new Director(builder);

           // 构建计算机
           Computer computer = director.constructComputer("Intel i7", 16, "1TB SSD");

           // 输出结果
           System.out.println("CPU: " + computer.getCpu());
           System.out.println("Memory: " + computer.getMemory() + " GB");
           System.out.println("Hard Drive: " + computer.getHardDrive());
       }
   }
   
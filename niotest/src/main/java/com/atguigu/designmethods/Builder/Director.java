package com.atguigu.designmethods.Builder;

public class Director {
       private ComputerBuilder builder;

       public Director(ComputerBuilder builder) {
           this.builder = builder;
       }

       public Computer constructComputer(String cpu, int memory, String hardDrive) {
           builder.setCpu(cpu);
           builder.setMemory(memory);
           builder.setHardDrive(hardDrive);
           return builder.build();
       }
   }
   
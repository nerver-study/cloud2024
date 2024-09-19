package com.atguigu.designmethods.Builder;

public class ConcreteBuilder implements ComputerBuilder {
       private Computer.Builder builder;

       public ConcreteBuilder() {
           this.builder = new Computer.Builder();
       }

       @Override
       public void setCpu(String cpu) {
           builder.setCpu(cpu);
       }

       @Override
       public void setMemory(int memory) {
           builder.setMemory(memory);
       }

       @Override
       public void setHardDrive(String hardDrive) {
           builder.setHardDrive(hardDrive);
       }

       @Override
       public Computer build() {
           return builder.build();
       }
   }
   
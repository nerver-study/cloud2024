package com.atguigu.designmethods.Builder;

public class Computer {
       private String cpu;
       private int memory;
       private String hardDrive;

       public Computer(Builder builder) {
           this.cpu = builder.cpu;
           this.memory = builder.memory;
           this.hardDrive = builder.hardDrive;
       }

       public String getCpu() {
           return cpu;
       }

       public int getMemory() {
           return memory;
       }

       public String getHardDrive() {
           return hardDrive;
       }

       // Builder 类
       public static class Builder {
           private String cpu;
           private int memory;
           private String hardDrive;

           public Builder setCpu(String cpu) {
               this.cpu = cpu;
               return this;
           }

           public Builder setMemory(int memory) {
               this.memory = memory;
               return this;
           }

           public Builder setHardDrive(String hardDrive) {
               this.hardDrive = hardDrive;
               return this;
           }

           public Computer build() {
               return new Computer(this);
           }
       }
   }
   
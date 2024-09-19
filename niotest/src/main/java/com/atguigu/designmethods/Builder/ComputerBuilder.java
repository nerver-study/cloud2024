package com.atguigu.designmethods.Builder;

public interface ComputerBuilder {
       void setCpu(String cpu);
       void setMemory(int memory);
       void setHardDrive(String hardDrive);
       Computer build();
   }
   
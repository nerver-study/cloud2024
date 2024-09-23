package com.atguigu.designmethods.FacadePattern;

public class SubsystemAImpl implements SubsystemA {
    @Override
    public void operationA() {
        System.out.println("Subsystem A: Performing operation A");
    }
}

 class SubsystemBImpl implements SubsystemB {
    @Override
    public void operationB() {
        System.out.println("Subsystem B: Performing operation B");
    }
}

 class SubsystemCImpl implements SubsystemC {
    @Override
    public void operationC() {
        System.out.println("Subsystem C: Performing operation C");
    }
}

package com.atguigu.designmethods.FacadePattern;

public class Facade {
    private final SubsystemA subsystemA;
    private final SubsystemB subsystemB;
    private final SubsystemC subsystemC;

    public Facade(SubsystemA subsystemA, SubsystemB subsystemB, SubsystemC subsystemC) {
        this.subsystemA = subsystemA;
        this.subsystemB = subsystemB;
        this.subsystemC = subsystemC;
    }

    public void performComplexOperation() {
        System.out.println("Facade: Starting complex operation...");
        subsystemA.operationA();
        subsystemB.operationB();
        subsystemC.operationC();
        System.out.println("Facade: Complex operation completed.");
    }
}

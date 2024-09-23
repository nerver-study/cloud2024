package com.atguigu.designmethods.FacadePattern;

public class Main {
    public static void main(String[] args) {
        SubsystemA subsystemA = new SubsystemAImpl();
        SubsystemB subsystemB = new SubsystemBImpl();
        SubsystemC subsystemC = new SubsystemCImpl();

        Facade facade = new Facade(subsystemA, subsystemB, subsystemC);

        facade.performComplexOperation();
    }
}

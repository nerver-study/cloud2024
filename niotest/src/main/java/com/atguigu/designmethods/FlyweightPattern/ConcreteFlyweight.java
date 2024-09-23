package com.atguigu.designmethods.FlyweightPattern;

public class ConcreteFlyweight implements Flyweight {
    private final String intrinsicState;

    public ConcreteFlyweight(String intrinsicState) {
        this.intrinsicState = intrinsicState;
    }

    @Override
    public void operation(String extrinsicState) {
        System.out.println("ConcreteFlyweight: " + intrinsicState + " - Extrinsic State: " + extrinsicState);
    }
}

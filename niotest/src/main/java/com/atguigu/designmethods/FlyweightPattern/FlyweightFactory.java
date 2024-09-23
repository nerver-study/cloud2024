package com.atguigu.designmethods.FlyweightPattern;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {
    private final Map<String, Flyweight> flyweights = new HashMap<>();

    public Flyweight getFlyweight(String intrinsicState) {
        Flyweight flyweight = flyweights.get(intrinsicState);
        if (flyweight == null) {
            flyweight = new ConcreteFlyweight(intrinsicState);
            flyweights.put(intrinsicState, flyweight);
            System.out.println("FlyweightFactory: Created new flyweight with intrinsic state: " + intrinsicState);
        }
        return flyweight;
    }
}

package com.atguigu.designmethods.atomClone.deep;

public class OldSheep implements Cloneable {
    private static final long serialVersionUID= 1L;
    private String name;
    private int age;
    private String color;
 
    public OldSheep(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }
 
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
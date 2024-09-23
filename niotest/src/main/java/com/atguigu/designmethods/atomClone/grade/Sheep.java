package com.atguigu.designmethods.atomClone.grade;

public class Sheep implements Cloneable{
    private String name;
    private int age;
    private String color;
 
    public Sheep(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public int getAge() {
        return age;
    }
 
    public void setAge(int age) {
        this.age = age;
    }
 
    public String getColor() {
        return color;
    }
 
    public void setColor(String color) {
        this.color = color;
    }
 
    @Override
    public String toString() {
        return "sheep{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
 
    //克隆该示例，使用默认的clone()方法
    @Override
    protected Object clone(){
        Sheep sheep = null;
        try {
            sheep = (Sheep) super.clone();
            //这是浅拷贝
            //浅拷贝就是  如果是一个数组，拷贝以后都会指向同一个地址，并没有重新开辟空间
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return sheep;
    }
}
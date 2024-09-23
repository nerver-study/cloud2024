package com.atguigu.designmethods.atomClone;

public class Client {
    public static void main(String[] args) {
        //传统模式
        Sheep sheep = new Sheep("喜羊羊", 1, "白色");
        //传统方式克隆
        Sheep sheep2 = new Sheep(sheep.getName(), sheep.getAge(), sheep.getColor());
        System.out.println(sheep);
        System.out.println(sheep2);
    }
}
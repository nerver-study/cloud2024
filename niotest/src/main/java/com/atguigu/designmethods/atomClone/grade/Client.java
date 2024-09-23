package com.atguigu.designmethods.atomClone.grade;

public class Client {
    public static void main(String[] args) {
        //原型模式
        Sheep sheep = new Sheep("喜羊羊", 1, "白色");
        //浅拷贝克隆
        Sheep sheep2 = (Sheep) sheep.clone();
        System.out.println(sheep2);
    }
}
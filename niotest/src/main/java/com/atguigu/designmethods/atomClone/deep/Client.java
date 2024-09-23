package com.atguigu.designmethods.atomClone.deep;

public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        Sheep sheep = new Sheep();
        sheep.name = "喜羊羊";
        sheep.friend = new OldSheep("美羊羊",1,"白色");
        //深拷贝克隆   重写克隆方法，将内部的对象也进行一次克隆
        Sheep sheep2 = (Sheep)sheep.clone();
        System.out.println("name:"+sheep.name+" sheep.friend:"+sheep.friend.hashCode());
        System.out.println("name:"+sheep2.name+" sheep2.friend:"+sheep2.friend.hashCode());
 
    }
}
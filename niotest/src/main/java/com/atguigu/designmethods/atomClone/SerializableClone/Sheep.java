package com.atguigu.designmethods.atomClone.SerializableClone;


import java.io.Serializable;

public class Sheep implements Cloneable, Serializable {
    private static final long serialVersionUID= 132L;
    public String name;
    public OldSheep friend;
    public Sheep() {
       super();
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", friend=" + friend +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OldSheep getFriend() {
        return friend;
    }

    public void setFriend(OldSheep friend) {
        this.friend = friend;
    }

    //深拷贝-重写克隆方法
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object deep = null;
        //完成对基本数据类型的克隆
        deep = super.clone();
        //对引用类型的属性，单独处理
        Sheep sheep = (Sheep)deep;
        sheep.friend = (OldSheep) friend.clone();
        return deep;
    }


}
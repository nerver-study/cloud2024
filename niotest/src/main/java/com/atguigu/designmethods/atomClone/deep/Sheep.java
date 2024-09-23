package com.atguigu.designmethods.atomClone.deep;

public class Sheep implements Cloneable{
    public String name;
    public OldSheep friend;
    public Sheep() {
       super();
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
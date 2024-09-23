package com.atguigu.designmethods.atomClone.SerializableClone;

public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        //序列化深拷贝
        Sheep sheep = new Sheep();
        sheep.name = "喜羊羊";
        sheep.friend = new OldSheep("美羊羊",1,"白色");
 
        //方式2 - 完成深拷贝克隆
        Sheep sheep2 = DeepCopyUtil.deepCopy(sheep);
        System.out.println("name:"+sheep.name+" sheep.friend:"+sheep.friend.hashCode());
        System.out.println("name:"+sheep2.name+" sheep2.friend:"+sheep2.friend.hashCode());


        test();
    }


    private static void test() throws CloneNotSupportedException {
        Sheep sheep = new Sheep();
        sheep.name = "喜羊羊";
        sheep.friend = new OldSheep("美羊羊",1,"白色");

        //方式2 - 完成深拷贝克隆
        Sheep sheep2 = DeepCopyUtil.deepCopy(sheep);
        System.out.println("name:"+sheep.name+" sheep.friend:"+sheep.friend.hashCode());
        System.out.println("name:"+sheep2.name+" sheep2.friend:"+sheep2.friend.hashCode());
    }


}

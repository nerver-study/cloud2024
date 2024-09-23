package com.atguigu.designmethods.CompositePattern;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 创建组合节点
        Composite root = new Composite("Root");
        Composite branch1 = new Composite("Branch 1");
        Composite branch2 = new Composite("Branch 2");

        // 创建叶子节点
        Leaf leaf1 = new Leaf("Leaf 1");
        Leaf leaf2 = new Leaf("Leaf 2");
        Leaf leaf3 = new Leaf("Leaf 3");
        Leaf leaf4 = new Leaf("Leaf 4");

        // 组合节点添加叶子节点
        branch1.add(leaf1);
        branch1.add(leaf2);
        branch2.add(leaf3);
        branch2.add(leaf4);

        // 根节点添加分支节点
        root.add(branch1);
        root.add(branch2);

        // 执行操作
        root.operation();
    }
}

package com.atguigu.designmethods.CompositePattern;

public interface Component {
    void add(Component component);
    void remove(Component component);
    Component getChild(int index);
    void operation();
}

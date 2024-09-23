package com.atguigu.designmethods.CompositePattern;

public class Leaf implements Component {
    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void add(Component component) {
        System.out.println("Leaf cannot add components.");
    }

    @Override
    public void remove(Component component) {
        System.out.println("Leaf cannot remove components.");
    }

    @Override
    public Component getChild(int index) {
        System.out.println("Leaf does not have children.");
        return null;
    }

    @Override
    public void operation() {
        System.out.println("Leaf " + name + ": Performing operation.");
    }
}

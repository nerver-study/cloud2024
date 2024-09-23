package com.atguigu.designmethods.CompositePattern;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    private String name;
    private List<Component> children = new ArrayList<>();

    public Composite(String name) {
        this.name = name;
    }

    @Override
    public void add(Component component) {
        children.add(component);
        System.out.println("Composite " + name + ": Adding component " + component);
    }

    @Override
    public void remove(Component component) {
        children.remove(component);
        System.out.println("Composite " + name + ": Removing component " + component);
    }

    @Override
    public Component getChild(int index) {
        if (index >= 0 && index < children.size()) {
            return children.get(index);
        }
        return null;
    }

    @Override
    public void operation() {
        System.out.println("Composite " + name + ": Performing operation.");
        for (Component child : children) {
            child.operation();
        }
    }
}

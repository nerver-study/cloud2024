package com.atguigu.designmethods.factory;


//简单工厂模式
interface Product {
    void operation();
}
class ConcreteProductA implements Product {
    @Override
    public void operation() {
        System.out.println("ConcreteProductA is working.");
    }
}

class ConcreteProductB implements Product {
    @Override
    public void operation() {
        System.out.println("ConcreteProductB is working.");
    }
}
class ProductFactory {
    public Product createProduct(String type) {
        if ("A".equals(type)) {
            return new ConcreteProductA();
        } else if ("B".equals(type)) {
            return new ConcreteProductB();
        } else {
            throw new IllegalArgumentException("Invalid product type: " + type);
        }
    }
}
public class FactoryPatternDemo {
    public static void main(String[] args) {
        ProductFactory factory = new ProductFactory();

        // 创建 ConcreteProductA 对象
        Product productA = factory.createProduct("A");
        productA.operation();

        // 创建 ConcreteProductB 对象
        Product productB = factory.createProduct("B");
        productB.operation();
    }
}


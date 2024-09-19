package com.atguigu.designmethods.Template;

public abstract class Game {
       // 定义游戏的基本流程
       public final void play() {
           initialize();
           startPlay();
           endPlay();
       }


//    final 方法：
//    当一个方法被声明为 final，意味着它是不可重写的（overriding）。这意味着任何继承该类的子类都不能改变这个方法的行为。这对于那些希望在基类中固定某个方法的具体实现是非常有用的。
//    final 方法可以被继承，但不能被子类覆盖（override）。这有助于保护方法的实现，使其不被修改。
//    final 类：
//    当一个类被声明为 final，意味着这个类不能被继承。这对于那些不想让其他类扩展自己的类来说非常有用。
//    final 类不能有子类。这有助于保证类的设计意图不会被其他类通过继承的方式改变。
//    final 变量：
//    对于基本数据类型的 final 变量，一旦赋值就不能再改变其值，相当于一个常量。
//    对于引用类型的 final 变量，一旦指向某个对象后，不能再指向另一个对象，但是对象的内容可以改变（除非对象本身也是 final 的）。


       // 具体实现留给子类
       protected abstract void initialize();

       protected abstract void startPlay();

       protected abstract void endPlay();
   }
   
package com.atguigu.designmethods.single;

public class InstructionReorderingExample {

    private static volatile    int x = 0, y = 0;
    private static volatile  int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10000; i++) {
            x = 0; y = 0;
            a = 0; b = 0;

            Thread one = new Thread(() -> {
                a = 1;  //语句1
                y = b;  //语句2
            });

            Thread two = new Thread(() -> {
                b = 1;  //语句3
                x = a;  //语句4
            });

            one.start();
            two.start();
            one.join();
            two.join();

            if (x == 0 && y == 0) {
                System.out.println("第 " + i + " 次发生了指令重排");
            }
        }
    }
}

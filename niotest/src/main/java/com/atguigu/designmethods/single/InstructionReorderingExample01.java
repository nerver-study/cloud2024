package com.atguigu.designmethods.single;

public class InstructionReorderingExample01 {

    private volatile int a = 0;
    private volatile boolean flag = false;

    public void threadA() {
        a = 1;
        flag = true;
    }

    public void threadB() {
        while (!flag) {
            // 等待 flag 变为 true
        }
        System.out.println(a);
    }

    public static void main(String[] args) throws InterruptedException {
        InstructionReorderingExample01 example = new InstructionReorderingExample01();
        Thread thread1 = new Thread(() -> example.threadA());
        Thread thread2 = new Thread(() -> example.threadB());

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}
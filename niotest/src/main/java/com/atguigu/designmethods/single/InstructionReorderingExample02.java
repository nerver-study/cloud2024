package com.atguigu.designmethods.single;

public class InstructionReorderingExample02 {

    //指令重排案例
//    编译器可能会为了提高性能而调整代码的执行顺序。
//    这种调整通常是安全的，但在多线程环境中可能会导致问题。

    private int a = 0;
    private boolean flag = false;

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
        InstructionReorderingExample02 example = new InstructionReorderingExample02();
        Thread thread1 = new Thread(() -> example.threadA());
        Thread thread2 = new Thread(() -> example.threadB());

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}


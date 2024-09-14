package com.atguigu.designmethods.single;

public class VolatileExample {

    private volatile boolean running = true;

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void run() {
        while (running) {
            // 执行一些任务
            System.out.println("Running...");
        }
        System.out.println("Loop finished.");
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileExample example = new VolatileExample();
        Thread thread = new Thread(() -> example.run());
        thread.start();

        // 让线程运行一段时间
        Thread.sleep(1000);

        // 修改 running 的值
        example.setRunning(false);

        // 等待线程结束
        thread.join();
    }
}
//保证可见性：
//比喻：想象你在写一封信，然后把信放在桌子上。其他人（其他线程）能看到这封信的内容。当你修改了信的内容并重新放回桌子上时，其他人立刻就能看到最新的内容。
//实际应用：当你在一个线程中修改了一个 volatile 变量的值，其他线程马上就能看到这个修改后的值。

//禁止指令重排序：
//比喻：想象你在做一系列动作，比如先洗手再吃饭。如果有人告诉你必须按顺序来做这些动作，不能颠倒顺序，那么这就是禁止指令重排序。
//实际应用：当你在多线程环境中修改一个 volatile 变量时，这个操作不会被打乱顺序。编译器和处理器不会把相关的操作重新排序。

//不保证原子性：
//比喻：假设你要往银行账户里存钱，存入 100 元。如果你的操作不是原子性的，可能会出现中途被打断的情况，导致你只存了一部分钱。
//实际应用：volatile 变量本身不保证复合操作的原子性。例如，volatile int count = 0; 和 count++ 不是原子性的。如果需要复合操作的原子性，可以使用 synchronized 或者 AtomicInteger。


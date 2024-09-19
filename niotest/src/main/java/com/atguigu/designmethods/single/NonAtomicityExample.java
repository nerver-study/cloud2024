package com.atguigu.designmethods.single;

public class NonAtomicityExample {

    private static   int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread incrementThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                count++;
            }
        });

        Thread decrementThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                count--;
            }
        });

        incrementThread.start();
        decrementThread.start();

        incrementThread.join();
        decrementThread.join();

        System.out.println("Final count value: " + count);
    }
}

package com.atguigu.zero;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.function.IntConsumer;

class ZeroEvenOdd09 {
    private int n;
    CyclicBarrier[] cbs = new CyclicBarrier[3];

    public ZeroEvenOdd09(int n) {
        this.n = n;
        for (int i=0; i<cbs.length; i++) cbs[i] = new CyclicBarrier(2);
    }

    //CyclicBarrier是一个同步辅助类，用于在一组线程中等待所有线程到达某个屏障点后才能继续执行。
    // 在这个例子中，每个CyclicBarrier对象的容量被设置为2，意味着必须有两个线程到达屏障点才能继续执行。
    // 当所有线程都到达屏障点时，CyclicBarrier对象会被重置，等待下一组线程到达屏障点。
    // 每个线程在调用await()方法时都会阻塞，直到所有线程都到达屏障点后才会继续执行。


    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i=1; i<=n; i++) {
            printNumber.accept(0);
            try {
                if (i % 2 == 1) {
                    cbs[1].await();
                } else {
                    cbs[2].await();
                }
                cbs[0].await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i=2; i<=n; i+=2) {
            try {
                cbs[2].await();
                printNumber.accept(i);
                cbs[0].await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i=1; i<=n; i+=2) {
            try {
                cbs[1].await();
                printNumber.accept(i);
                cbs[0].await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }



    public static void main(String[] args) throws InterruptedException {
//        testCyclicBarrier();
        CyclicBarrier[] cbs = new CyclicBarrier[3];

        for (int i=0; i<cbs.length; i++) cbs[i] = new CyclicBarrier(2);
        for (int i=1; i<=5; i++) {
            System.out.println("000000000");
            try {
                if (i % 2 == 1) {
                    System.out.println("22222222222");
                    cbs[1].await();
                } else {
                    System.out.println("33333333");
                    cbs[2].await();
                }
                System.out.println("1111111111111");
                cbs[0].await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    private static void testCyclicBarrier() {
        // 设置参赛者数量
        final int numberOfRunners = 4;
        // 创建CyclicBarrier，参数为参赛者数量
        final CyclicBarrier startLine = new CyclicBarrier(numberOfRunners, () -> {
            System.out.println("所有参赛者准备完毕，比赛开始！");
        });

        // 创建并启动每个参赛者线程
        for (int i = 0; i < numberOfRunners; i++) {
            Thread runner = new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " 准备完毕，等待发令枪！");
                    // 等待所有参赛者到达起跑线
                    startLine.await();
                    System.out.println(Thread.currentThread().getName() + " 开始跑步！");
                } catch (InterruptedException | BrokenBarrierException e) {
                    Thread.currentThread().interrupt();
                }
            });
            runner.setName("Runner-" + i);
            runner.start();
        }
    }
}


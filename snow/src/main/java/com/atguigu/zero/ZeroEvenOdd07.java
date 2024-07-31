package com.atguigu.zero;

import java.util.concurrent.SynchronousQueue;
import java.util.function.IntConsumer;

class ZeroEvenOdd07 {
    private int n;
    private SynchronousQueue<Integer>[] queues = new SynchronousQueue[3];
    //SynchronousQueue是一个同步队列，每个队列在放入元素前必须等待另一个线程取出元素，常用于线程之间的通信。
    //SynchronousQueue是一个阻塞队列，它的特点是：它只允许一个线程插入元素，另一个线程取出元素。
    //SynchronousQueue是一个线程安全的队列，它的特点是：它只允许一个线程插入元素，另一个线程取出元素。
    //放1个取1个，不然就会阻塞

    public ZeroEvenOdd07(int n) {
        this.n = n;
        for (int i=0; i<queues.length; i++) queues[i] = new SynchronousQueue<>();
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i=1; i<=n; i++) {
            printNumber.accept(0);
            if (i % 2 == 1) {
                queues[1].put(1);
            } else {
                queues[2].put(1);
            }
            queues[0].take();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i=2; i<=n; i+=2) {
            queues[2].take();
            printNumber.accept(i);
            queues[0].put(1);
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i=1; i<=n; i+=2) {
            queues[1].take();
            printNumber.accept(i);
            queues[0].put(1);
        }
    }
}


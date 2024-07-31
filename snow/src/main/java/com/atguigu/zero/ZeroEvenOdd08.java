package com.atguigu.zero;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.IntConsumer;

class ZeroEvenOdd08 {
    private int n;
    private LinkedBlockingQueue<Integer>[] queues = new LinkedBlockingQueue[3];

    public ZeroEvenOdd08(int n) {
        this.n = n;
        for (int i=0; i<queues.length; i++) {
            queues[i] = new LinkedBlockingQueue<>(1);
            //设置队列的最大容量。
            // 这意味着队列只能容纳一个元素。
            // 当队列已满（即包含一个元素）时，任何试图通过put方法添加新元素的操作都将被阻塞，直到队列中的某个元素被消费掉。
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        queues[0].put(1);
        for (int i=1; i<=n; i++) {
            queues[0].take();
            printNumber.accept(0);
            if (i % 2 == 0) {
                queues[2].put(1);
            } else {
                queues[1].put(1);
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i=2; i<=n; i+=2) {
            queues[2].take();
            printNumber.accept(i);
            if (i < n) queues[0].put(1);
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i=1; i<=n; i+=2) {
            queues[1].take();
            printNumber.accept(i);
            if (i < n) queues[0].put(1);
        }
    }
}


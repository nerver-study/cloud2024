package com.atguigu.zero;

import java.util.function.IntConsumer;

class ZeroEvenOdd01 {
    private int n;
    private volatile int flag = 1;

    public ZeroEvenOdd01(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            synchronized (this) {
                while (flag % 2 == 0)
                    wait();
                printNumber.accept(0);
                flag++;
                notifyAll();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            synchronized (this) {
                while (flag % 4 != 0)
                    wait();
                printNumber.accept(i);
                flag++;
                notifyAll();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            synchronized (this) {
                while (flag % 4 != 2)
                    wait();
                printNumber.accept(i);
                flag++;
                notifyAll();
            }
        }
    }
}

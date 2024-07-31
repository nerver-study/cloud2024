package com.atguigu.zero;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class ZeroEvenOdd06 {
    private int n;
    Semaphore[] semaphores = new Semaphore[3];

    public ZeroEvenOdd06(int n) {
        this.n = n;
        semaphores[0] = new Semaphore(1);
        semaphores[1] = new Semaphore(0);
        semaphores[2] = new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i=1; i<=n; i++) {
            semaphores[0].acquire();
            printNumber.accept(0);
            if (i % 2 == 0) semaphores[1].release();
            else semaphores[2].release();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i=2; i<=n; i=i+2) {
            //acquire()方法用于获取信号量的许可，如果当前没有可用的许可，则当前线程将被阻塞，直到获取到许可为止。
            semaphores[1].acquire();
            printNumber.accept(i);
            semaphores[0].release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i=1; i<=n; i=i+2) {
            semaphores[2].acquire();
            printNumber.accept(i);
            semaphores[0].release();
        }
    }
}


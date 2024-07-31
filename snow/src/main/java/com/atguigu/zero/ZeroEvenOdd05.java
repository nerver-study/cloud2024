package com.atguigu.zero;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

class ZeroEvenOdd05 {
    private int n;
    private volatile int flag = 1;
    private ReentrantLock lock = new ReentrantLock();
    private Condition[] conditions = new Condition[3];

    public ZeroEvenOdd05(int n) {
        this.n = n;
        for (int i=0; i<conditions.length; i++) conditions[i] = lock.newCondition();
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i=1; i<=n; i++) {
            lock.lock();
            printNumber.accept(0);
            flag ++;
            if (flag % 4 == 2) {
                conditions[1].signal();
            }
            if (flag % 4 == 0) {
                conditions[2].signal();
            }
            if (flag % 2 == 0) {
                conditions[0].await();
            }
            lock.unlock();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i=2; i<=n; i+=2) {
            lock.lock();
            if (flag % 4 != 0) conditions[2].await();
            printNumber.accept(i);
            flag ++;
            conditions[0].signal();
            lock.unlock();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i=1; i<=n; i+=2) {
            lock.lock();
            if (flag % 4 != 2) conditions[1].await();
            printNumber.accept(i);
            flag ++;
            conditions[0].signal();
            lock.unlock();
        }
    }
}


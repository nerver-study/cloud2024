package com.atguigu.zero;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.LockSupport;
import java.util.function.IntConsumer;

class ZeroEvenOdd02 {
    private int n;
    volatile int flag = 1;
    ConcurrentHashMap<Integer, Thread> map = new ConcurrentHashMap<>();

    public ZeroEvenOdd02(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        map.putIfAbsent(1, Thread.currentThread());

        for (int i=1; i<=n; i++) {
            while (flag % 2 == 0) LockSupport.park();
            printNumber.accept(0);
            flag ++;
            if (flag % 4 == 0) LockSupport.unpark(map.get(0));
            if (flag % 4 == 2) LockSupport.unpark(map.get(1));
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        map.putIfAbsent(0, Thread.currentThread());
        for (int i=2; i<=n; i+=2) {
            while (flag % 4 != 0) LockSupport.park(); //这个方法会让当前线程暂停执行，进入等待状态，直到其他线程调用unpark()方法来唤醒它。
            printNumber.accept(i);
            flag ++;
            LockSupport.unpark(map.get(1));
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i=1; i<=n; i+=2) {
            while (flag % 4 != 2) LockSupport.park();
            printNumber.accept(i);
            flag ++;
            LockSupport.unpark(map.get(1));
        }
    }
}


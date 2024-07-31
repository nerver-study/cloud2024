package com.atguigu.zero;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

class ZeroEvenOdd04 {
    private int n;
    private volatile int flag = 1;
    private ReentrantLock lock = new ReentrantLock();//上锁和释放锁
    private Condition condition = lock.newCondition();//用于线程间的通信
    
    public ZeroEvenOdd04(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i=1; i<=n; i++) {
            lock.lock();
            printNumber.accept(0);
            flag ++;
            //唤醒所有等待在该条件变量上的线程。
            // 当某个线程调用condition.await()方法后，它会被阻塞并释放持有的锁，直到其他线程调用signalAll()方法通知它，它才会重新竞争锁并进入就绪状态。
            condition.signalAll();
            while (flag %2 == 0) condition.await();
            lock.unlock();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i=2; i<=n; i+=2) {
            lock.lock();
            while (flag % 4 != 0) condition.await();
            printNumber.accept(i);
            flag ++;
            condition.signalAll();
            lock.unlock();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i=1; i<=n; i+=2) {
            lock.lock();
            while (flag % 4 != 2) condition.await();
            printNumber.accept(i);
            flag ++;
            condition.signalAll();
            lock.unlock();
        }       
    }
}


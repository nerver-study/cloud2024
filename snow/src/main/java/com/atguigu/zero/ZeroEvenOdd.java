package com.atguigu.zero;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private int n;
    Exchanger<Integer>[] exchanges = new Exchanger[3];

    public ZeroEvenOdd(int n) {
        this.n = n;
        for (int i=0; i< exchanges.length; i++) exchanges[i] = new Exchanger<>();
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i=1; i<=n; i++) {
            printNumber.accept(0);
            if (i % 2 == 1) {
                exchanges[1].exchange(1);
            } else {
                exchanges[2].exchange(1);
            }
            exchanges[0].exchange(1);
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i=2; i<=n; i+=2) {
            exchanges[2].exchange(1);
            printNumber.accept(i);
            exchanges[0].exchange(1);
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i=1; i<=n; i+=2) {
            exchanges[1].exchange(1);
            printNumber.accept(i);
            exchanges[0].exchange(1);
        }
    }
    public static void main(String[] args) {
        Exchanger<String> parkBench = new Exchanger<>();

        Thread you = new Thread(() -> {
            try {
                System.out.println("你带着漫画书走向长椅...");
                String yourItem = "漫画书";
                String exchangedItem = parkBench.exchange(yourItem);
                System.out.println("你在长椅上交换到了：" + exchangedItem);
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("你被中断了！");
            }
        });

        Thread friend = new Thread(() -> {
            try {
                System.out.println("你的朋友带着音乐专辑走向长椅...");
                String friendItem = "音乐专辑";
                String exchangedItem = parkBench.exchange(friendItem);
                System.out.println("你的朋友在长椅上交换到了：" + exchangedItem);
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("你的朋友被中断了！");
            }
        });

        you.start();
        friend.start();
    }
}

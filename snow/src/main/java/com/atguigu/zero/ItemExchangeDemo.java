package com.atguigu.zero;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

public class ItemExchangeDemo {

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

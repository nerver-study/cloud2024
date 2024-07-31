package com.atguigu;

import java.util.concurrent.*;

public class Main {
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


    private static void testSynchronousQueue() {
        // 创建SynchronousQueue实例
        SynchronousQueue<String> queue = new SynchronousQueue<>();

        // 启动生产者线程
        Thread producerThread = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Producing: " + i);
                    queue.put("Item " + i);
                    TimeUnit.MILLISECONDS.sleep(500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Producer interrupted");
            }
        });

        // 启动消费者线程
        Thread consumerThread = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    String item = queue.take();
                    System.out.println("Consuming: " + item);
                    TimeUnit.MILLISECONDS.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Consumer interrupted");
            }
        });

        // 启动线程
        producerThread.start();
        consumerThread.start();

        // 等待线程结束
        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static void testputIfAbsent() {
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        String oldValue = map.putIfAbsent(1, "Value1");
        String oldValue1 = map.putIfAbsent(1, "Value2");
        System.out.println(oldValue);//null
        System.out.println(oldValue1);//Value1
        //putIfAbsent方法，如果key不存在，则添加，如果存在，则不添加，返回key对应的value
    }
}
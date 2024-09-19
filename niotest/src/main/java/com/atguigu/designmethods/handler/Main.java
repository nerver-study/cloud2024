package com.atguigu.designmethods.handler;

public class Main {
       public static void main(String[] args) {
           // 创建处理者链
           Handler manager = new Manager();
           Handler director = new Director();
           Handler ceo = new CEO();

           // 设置处理者的顺序
           manager.setNext(director);
           director.setNext(ceo);

           // 创建请假请求并处理
           LeaveRequest request1 = new LeaveRequest(2);
           LeaveRequest request2 = new LeaveRequest(5);
           LeaveRequest request3 = new LeaveRequest(10);
           LeaveRequest request4 = new LeaveRequest(15);

           manager.handleRequest(request1); // 应由经理批准
           manager.handleRequest(request2); // 应由总监批准
           manager.handleRequest(request3); // 应由 CEO 批准
           manager.handleRequest(request4); // 应由 CEO 批准
       }
   }
   
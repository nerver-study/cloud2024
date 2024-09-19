package com.atguigu.designmethods.handler;

public abstract class Handler {
       protected Handler nextHandler;

       public void setNext(Handler nextHandler) {
           this.nextHandler = nextHandler;
       }

       public abstract void handleRequest(LeaveRequest request);
   }
   
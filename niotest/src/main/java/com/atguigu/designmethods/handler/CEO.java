package com.atguigu.designmethods.handler;

public class CEO extends Handler {
       @Override
       public void handleRequest(LeaveRequest request) {
           if (request.getDays() <= 14) {
               System.out.println("CEO approved " + request.getDays() + " days leave.");
           } else if (nextHandler != null) {
               nextHandler.handleRequest(request);
           } else {
               System.out.println("Leave request denied.");
           }
       }
   }
   
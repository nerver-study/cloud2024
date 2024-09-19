package com.atguigu.designmethods.handler;

public class Manager extends Handler {
       @Override
       public void handleRequest(LeaveRequest request) {
           if (request.getDays() <= 3) {
               System.out.println("Manager approved " + request.getDays() + " days leave.");
           } else if (nextHandler != null) {
               nextHandler.handleRequest(request);
           } else {
               System.out.println("Leave request denied.");
           }
       }
   }
   
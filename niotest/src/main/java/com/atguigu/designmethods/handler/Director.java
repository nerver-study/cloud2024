package com.atguigu.designmethods.handler;

public class Director extends Handler {
       @Override
       public void handleRequest(LeaveRequest request) {
           if (request.getDays() <= 7) {
               System.out.println("Director approved " + request.getDays() + " days leave.");
           } else if (nextHandler != null) {
               nextHandler.handleRequest(request);
           } else {
               System.out.println("Leave request denied.");
           }
       }
   }
   
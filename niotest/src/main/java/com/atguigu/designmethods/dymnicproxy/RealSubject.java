package com.atguigu.designmethods.dymnicproxy;

class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("RealSubject is processing the request.");
    }
}

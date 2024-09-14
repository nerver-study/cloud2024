package com.atguigu.designmethods.staticproxy;

class Proxy implements Subject {
    private RealSubject realSubject;

    public Proxy() {
        this.realSubject = new RealSubject();
    }

    @Override
    public void request() {
        preRequest();
        realSubject.request();
        postRequest();
    }

    private void preRequest() {
        System.out.println("Proxy is performing pre-request operations.");
    }

    private void postRequest() {
        System.out.println("Proxy is performing post-request operations.");
    }
}

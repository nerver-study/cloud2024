package com.atguigu.designmethods.staticproxy.cache;


import com.atguigu.designmethods.staticproxy.RealSubject;



class CachingProxy implements Subject {
    private RealSubject realSubject;
    private boolean cached = false;
    private String cacheResult;

    public CachingProxy() {
        this.realSubject = new RealSubject();
    }

    @Override
    public void request() {
        if (!cached) {
            preRequest();
            realSubject.request();
            cacheResult = "Cached Result";
            cached = true;
            postRequest();
        } else {
            System.out.println("CachingProxy is using cached result: " + cacheResult);
        }
    }

    private void preRequest() {
        System.out.println("CachingProxy is performing pre-request operations.");
    }

    private void postRequest() {
        System.out.println("CachingProxy is performing post-request operations.");
    }
}
interface Subject {
    void request();
}
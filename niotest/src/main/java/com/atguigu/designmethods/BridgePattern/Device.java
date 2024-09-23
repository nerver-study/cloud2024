package com.atguigu.designmethods.BridgePattern;

public abstract class Device {
    protected RemoteControl remoteControl;

    public Device(RemoteControl remoteControl) {
        this.remoteControl = remoteControl;
    }

    public abstract void turnOn();
    public abstract void turnOff();
}

 class TV extends Device {
    public TV(RemoteControl remoteControl) {
        super(remoteControl);
    }

    @Override
    public void turnOn() {
        System.out.println("TV is turned on.");
        remoteControl.turnOn();
    }

    @Override
    public void turnOff() {
        System.out.println("TV is turned off.");
        remoteControl.turnOff();
    }
}

 class Radio extends Device {
    public Radio(RemoteControl remoteControl) {
        super(remoteControl);
    }

    @Override
    public void turnOn() {
        System.out.println("Radio is turned on.");
        remoteControl.turnOn();
    }

    @Override
    public void turnOff() {
        System.out.println("Radio is turned off.");
        remoteControl.turnOff();
    }
}

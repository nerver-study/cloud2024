package com.atguigu.designmethods.observer;

import java.util.ArrayList;
import java.util.List;

//总体来说设计模式分为三大类：

//创建型模式，共五种：工厂方法模式（简单工厂模式）、抽象工厂模式、单例模式、建造者模式、原型模式

//结构型模式，共七种：适配器模式、装饰器模式、代理模式、外观模式、桥接模式、组合模式、享元模式。

//行为型模式，共十一种：策略模式、模板方法模式、观察者模式、迭代子模式、责任链模式、命令模式、备忘录模式、状态模式、访问者模式、中介者模式、解释器模式。

//设计模式知道的：观察者模式  、抽象工厂模式,代理模式
//不需要过度关注的：工厂方法模式（简单工厂模式），适配器模式  责任链模式  其实就是简单的多态玩一下，通过类型判断
//              模板方法，装饰器模式，建造者模式
//


// 主题接口
//被观察者接口 (Subject)
interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

// 观察者接口
interface Observer {
    void update(float temp, float humidity, float pressure);
}

//被观察者类 (WeatherData):
// 天气数据源 - 具体主题
class WeatherData implements Subject {
    private List<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }

    public void measurementsChanged() {
        notifyObservers();
    }

    // 设置新的测量值
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}

//观察者类 (CurrentConditionsDisplay 和 StatisticsDisplay):
// 温度显示 - 具体观察者
class CurrentConditionsDisplay implements Observer {
    private float temperature;
    private float humidity;
    private Subject weatherData;
    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }
    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }

    public void display() {
        System.out.println("Current conditions: " + temperature + " F degrees and " + humidity + "% humidity");
    }
}


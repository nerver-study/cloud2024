package com.atguigu.designmethods.observer;

public class WeatherStation {
    public static void main(String[] args) {
        //这个是要观察的对象：天气
        WeatherData weatherData = new WeatherData();
        //这个是观察者
        //这个构造方法的作用：1.告诉观察者要观察天气   2.告诉天气被谁观察了
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);

        //设置天气的温度，然后告诉别的观察者
        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);
    }
}
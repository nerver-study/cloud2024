package com.atguigu.zero;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

public class WeatherForecastExchanger {

    //帮我写一个Exchanger的使用案例，让我了解学习一下

    public static void main(String[] args) {
        Exchanger<WeatherData> dataExchanger = new Exchanger<>();

        Thread weatherCollector = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    WeatherData collectedData = collectWeatherData();
                    System.out.println("Collector: Waiting to exchange data...");
                    WeatherData exchangedData = dataExchanger.exchange(collectedData);
                    System.out.println("Collector: Data exchanged.");
                    TimeUnit.SECONDS.sleep(2);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Collector interrupted.");
            }
        });

        Thread weatherProcessor = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Processor: Waiting to exchange data...");
                    WeatherData processedData = dataExchanger.exchange(new WeatherData());
                    System.out.println("Processor: Data received and processed.");
                    processWeatherData(processedData);
                    TimeUnit.SECONDS.sleep(3);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Processor interrupted.");
            }
        });

        weatherCollector.start();
        weatherProcessor.start();
    }

    private static WeatherData collectWeatherData() throws InterruptedException {
        System.out.println("Collector: Collecting weather data...");
        TimeUnit.SECONDS.sleep(1);
        return new WeatherData("Sunny", 25);
    }

    private static void processWeatherData(WeatherData data) {
        System.out.println("Processor: Processing weather data - " + data);
    }

    static class WeatherData {
        String condition;
        int temperature;

        public WeatherData(String condition, int temperature) {
            this.condition = condition;
            this.temperature = temperature;
        }

        public WeatherData() {

        }

        @Override
        public String toString() {
            return "WeatherData{" +
                    "condition='" + condition + '\'' +
                    ", temperature=" + temperature +
                    '}';
        }
    }
}

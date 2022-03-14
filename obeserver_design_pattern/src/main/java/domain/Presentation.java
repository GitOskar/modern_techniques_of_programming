package domain;

import domain.observer.TemperatureChangeObserver;
import domain.observer.implementation.AvgTemperatureObserver;
import domain.observer.implementation.WindChillObserver;
import domain.producer.implementation.MockedTemperatureChangeProducer;
import domain.producer.implementation.MockedWindChangeProducer;

public class Presentation {

    public static void main(String[] args) {

        MockedWindChangeProducer windChangeProducer = new MockedWindChangeProducer();
        MockedTemperatureChangeProducer temperatureChangeProducer = new MockedTemperatureChangeProducer();

        new Thread(() -> {
            while (true) {
                try {
                    windChangeProducer.generateRandomWindChanges();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                temperatureChangeProducer.generateRandomTemperatureChange();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        TemperatureChangeObserver firstAvg = new AvgTemperatureObserver();
        TemperatureChangeObserver secondAvg = new AvgTemperatureObserver();
        WindChillObserver windChillObserver = new WindChillObserver();

        windChangeProducer.addObserver(windChillObserver);

        temperatureChangeProducer.addObserver(firstAvg);
        temperatureChangeProducer.addObserver(secondAvg);
        temperatureChangeProducer.addObserver(windChillObserver);
    }
}
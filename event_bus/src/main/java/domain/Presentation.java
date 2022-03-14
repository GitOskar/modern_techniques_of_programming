package domain;

import domain.eventbus.Bus;
import domain.eventbus.BusImpl;
import domain.eventbus.EventType;
import domain.observer.Observer;
import domain.observer.implementation.AvgTemperatureObserver;
import domain.observer.implementation.WindChillObserver;
import domain.publisher.implementation.MockedTemperatureChangePublisher;
import domain.publisher.implementation.MockedWindChangePublisher;

public class Presentation {

    public static void main(String[] args) {

        Bus broker = new BusImpl();

        MockedWindChangePublisher windChangePublisher = new MockedWindChangePublisher(broker);
        MockedTemperatureChangePublisher temperatureChangePublisher = new MockedTemperatureChangePublisher(broker);

        new Thread(() -> {
            while (true) {
                try {
                    windChangePublisher.generateRandomWindChanges();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                temperatureChangePublisher.generateRandomTemperatureChange();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Observer firstAvg = new AvgTemperatureObserver();
        Observer secondAvg = new AvgTemperatureObserver();
        WindChillObserver windChillObserver = new WindChillObserver();

        broker.addObserver(windChillObserver, EventType.WIND_CHANGE);

        broker.addObserver(firstAvg, EventType.TEMPERATURE_CHANGE);
        broker.addObserver(secondAvg, EventType.TEMPERATURE_CHANGE);
        broker.addObserver(windChillObserver, EventType.TEMPERATURE_CHANGE);
    }
}
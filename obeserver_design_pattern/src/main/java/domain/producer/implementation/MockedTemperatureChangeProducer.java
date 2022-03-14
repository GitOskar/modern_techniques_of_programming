package domain.producer.implementation;

import domain.observer.TemperatureChangeObserver;
import domain.observer.dto.TemperatureChange;
import domain.producer.TemperatureChangeProducer;

import java.util.ArrayList;
import java.util.List;

import static domain.util.RandomUtil.nextDouble;

public class MockedTemperatureChangeProducer implements TemperatureChangeProducer {

    private static final double MIN_TEMPERATURE_RANGE = -30.0;
    private static final double MAX_TEMPERATURE_RANGE = 30.0;

    private final List<TemperatureChangeObserver> temperatureChangeObservers;

    public MockedTemperatureChangeProducer() {
        this.temperatureChangeObservers = new ArrayList<>();
    }

    public void generateRandomTemperatureChange() {
        TemperatureChange temperatureChange = new TemperatureChange(nextDouble(MIN_TEMPERATURE_RANGE, MAX_TEMPERATURE_RANGE));

        notifyObservers(temperatureChange);
    }

    @Override
    public void addObserver(TemperatureChangeObserver observer) {
        temperatureChangeObservers.add(observer);
    }

    @Override
    public void removeObserver(TemperatureChangeObserver observer) {
        temperatureChangeObservers.remove(observer);
    }

    @Override
    public void notifyObservers(TemperatureChange temperatureChange) {
        temperatureChangeObservers.forEach(observer -> observer.update(temperatureChange));
    }
}
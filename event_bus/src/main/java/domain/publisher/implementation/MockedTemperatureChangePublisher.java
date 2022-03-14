package domain.publisher.implementation;

import domain.eventbus.Bus;
import domain.eventbus.Event;
import domain.eventbus.EventType;
import domain.observer.dto.TemperatureChange;

import static domain.util.RandomUtil.nextDouble;

public class MockedTemperatureChangePublisher extends AbstractPublisher {

    private static final double MIN_TEMPERATURE_RANGE = -30.0;
    private static final double MAX_TEMPERATURE_RANGE = 30.0;

    public MockedTemperatureChangePublisher(Bus broker) {
        super(broker);
    }

    public void generateRandomTemperatureChange() {
        TemperatureChange temperatureChange = new TemperatureChange(nextDouble(MIN_TEMPERATURE_RANGE, MAX_TEMPERATURE_RANGE));

        Event<TemperatureChange> temperatureChangeEvent = new Event<>(EventType.TEMPERATURE_CHANGE, temperatureChange);

        publishEvent(temperatureChangeEvent);
    }
}
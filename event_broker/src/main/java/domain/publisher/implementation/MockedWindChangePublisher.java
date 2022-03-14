package domain.publisher.implementation;

import domain.eventbroker.Broker;
import domain.eventbroker.Event;
import domain.eventbroker.EventType;
import domain.observer.dto.WindChange;

import static domain.util.RandomUtil.nextDouble;

public class MockedWindChangePublisher extends AbstractPublisher {

    private static final double MIN_WIND_RANGE = 0.0;
    private static final double MAX_WIND_RANGE = 99.0;

    public MockedWindChangePublisher(Broker broker) {
        super(broker);
    }

    public void generateRandomWindChanges() {

        WindChange windChange = new WindChange(nextDouble(MIN_WIND_RANGE, MAX_WIND_RANGE));

        Event<WindChange> windChangeEvent = new Event<>(EventType.WIND_CHANGE, windChange);

        publishEvent(windChangeEvent);
    }
}

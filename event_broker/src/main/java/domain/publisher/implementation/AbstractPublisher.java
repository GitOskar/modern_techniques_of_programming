package domain.publisher.implementation;

import domain.eventbroker.Broker;
import domain.eventbroker.Event;
import domain.publisher.Publisher;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AbstractPublisher implements Publisher {

    protected final Broker broker;

    @Override
    public void publishEvent(Event<?> event) {
        broker.fire(event);
    }
}

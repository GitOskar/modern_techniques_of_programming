package domain.publisher.implementation;

import domain.eventbus.Bus;
import domain.eventbus.Event;
import domain.publisher.Publisher;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AbstractPublisher implements Publisher {

    protected final Bus bus;

    @Override
    public void publishEvent(Event<?> event) {
        bus.fire(event);
    }
}

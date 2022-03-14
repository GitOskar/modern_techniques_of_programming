package domain.publisher;

import domain.eventbus.Event;

public interface Publisher {

    void publishEvent(Event<?> event);
}

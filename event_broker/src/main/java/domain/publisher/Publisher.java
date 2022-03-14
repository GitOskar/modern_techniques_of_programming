package domain.publisher;

import domain.eventbroker.Event;

public interface Publisher {

    void publishEvent(Event<?> event);
}

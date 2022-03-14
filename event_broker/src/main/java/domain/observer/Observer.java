package domain.observer;

import domain.eventbroker.Event;

public interface Observer {

    void handle(Event<?> event);
}
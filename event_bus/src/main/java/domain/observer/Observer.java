package domain.observer;

import domain.eventbus.Event;

public interface Observer {

    void handle(Event<?> event);
}
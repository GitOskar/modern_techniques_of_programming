package domain.eventbroker;

import domain.observer.Observer;

public interface Broker {

    void addObserver(Observer observer, EventType eventType);

    void removeObserver(Observer observer, EventType eventType);

    void fire(Event<?> event);
}

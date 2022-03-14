package domain.eventbus;

import domain.observer.Observer;

public interface Bus {

    void addObserver(Observer observer, EventType eventType);

    void removeObserver(Observer observer, EventType eventType);

    void fire(Event<?> event);
}

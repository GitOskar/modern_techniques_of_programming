package domain.eventbus;

import domain.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class BusImpl implements Bus {

    private final List<Observer> observers = new ArrayList<>();

    @Override
    public synchronized void addObserver(Observer observer, EventType eventType) {
        observers.add(observer);
    }

    @Override
    public synchronized void removeObserver(Observer observer, EventType eventType) {
        observers.remove(observer);
    }

    @Override
    public synchronized void fire(Event<?> event) {
        observers.forEach(observer -> observer.handle(event));
    }
}

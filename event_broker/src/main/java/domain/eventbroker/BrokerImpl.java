package domain.eventbroker;

import domain.observer.Observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrokerImpl implements Broker {

    private final Map<EventType, List<Observer>> observers = new HashMap<>();

    @Override
    public synchronized void addObserver(Observer observer, EventType eventType) {

        if (observers.containsKey(eventType)) {
            observers.get(eventType)
                    .add(observer);
        } else {
            List<Observer> list = new ArrayList<>();
            list.add(observer);
            observers.put(eventType, list);
        }
    }

    @Override
    public synchronized void removeObserver(Observer observer, EventType eventType) {
        observers.getOrDefault(eventType, new ArrayList<>())
                .remove(observer);
    }

    @Override
    public synchronized void fire(Event<?> event) {
        observers.getOrDefault(event.getEventType(), new ArrayList<>())
                .forEach(observer -> observer.handle(event));
    }
}

package domain.producer;

import domain.observer.TemperatureChangeObserver;
import domain.observer.dto.TemperatureChange;

public interface TemperatureChangeProducer {

    void addObserver(TemperatureChangeObserver observer);
    void removeObserver(TemperatureChangeObserver observer);
    void notifyObservers(TemperatureChange temperatureChange);
}

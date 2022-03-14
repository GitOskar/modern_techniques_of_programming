package domain.observer;

import domain.observer.dto.TemperatureChange;

public interface TemperatureChangeObserver {

    void update(TemperatureChange temperatureChange);
}
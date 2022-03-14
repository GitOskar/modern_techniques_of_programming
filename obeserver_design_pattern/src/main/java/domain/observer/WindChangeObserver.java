package domain.observer;

import domain.observer.dto.TemperatureChange;
import domain.observer.dto.WindChange;

public interface WindChangeObserver {
    void update(WindChange windchange);
}

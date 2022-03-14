package domain.producer;

import domain.observer.WindChangeObserver;
import domain.observer.dto.WindChange;

public interface WindChangeProducer {

    void addObserver(WindChangeObserver observer);
    void removeObserver(WindChangeObserver observer);
    void notifyObservers(WindChange windChange);
}

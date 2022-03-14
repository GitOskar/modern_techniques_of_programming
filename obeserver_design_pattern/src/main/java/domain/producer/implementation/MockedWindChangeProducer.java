package domain.producer.implementation;

import domain.observer.WindChangeObserver;
import domain.observer.dto.WindChange;
import domain.producer.WindChangeProducer;

import java.util.ArrayList;
import java.util.List;

import static domain.util.RandomUtil.nextDouble;

public class MockedWindChangeProducer implements WindChangeProducer {

    private static final double MIN_WIND_RANGE = 0.0;
    private static final double MAX_WIND_RANGE = 99.0;

    private final List<WindChangeObserver> windChangeObservers;

    public MockedWindChangeProducer() {
        this.windChangeObservers = new ArrayList<>();
    }

    public void generateRandomWindChanges() {

        WindChange windChange = new WindChange(nextDouble(MIN_WIND_RANGE, MAX_WIND_RANGE));

        notifyObservers(windChange);
    }

    @Override
    public void addObserver(WindChangeObserver observer) {
        windChangeObservers.add(observer);
    }

    @Override
    public void removeObserver(WindChangeObserver observer) {
        windChangeObservers.remove(observer);
    }

    @Override
    public void notifyObservers(WindChange windChange) {
        this.windChangeObservers.forEach(observer -> observer.update(windChange));
    }
}

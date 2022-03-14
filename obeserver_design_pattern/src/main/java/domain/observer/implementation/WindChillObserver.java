package domain.observer.implementation;

import domain.observer.TemperatureChangeObserver;
import domain.observer.WindChangeObserver;
import domain.observer.dto.TemperatureChange;
import domain.observer.dto.WindChange;
import lombok.extern.slf4j.Slf4j;

import static java.util.Objects.nonNull;

@Slf4j
public class WindChillObserver implements TemperatureChangeObserver, WindChangeObserver {

    private TemperatureChange lastTemperatureChange;
    private WindChange lastWindChange;

    @Override
    public synchronized void update(TemperatureChange temperatureChange) {

        log.info("New temperature change: {}", temperatureChange);
        this.lastTemperatureChange = temperatureChange;
        handleEvents();
    }

    @Override
    public synchronized void update(WindChange windchange) {

        log.info("New wind change: {}", windchange);
        this.lastWindChange = windchange;
        handleEvents();
    }

    private synchronized void handleEvents() {

        if (nonNull(lastTemperatureChange)) {
            log.info("Updated perceptible temperature: {}", calculatePerceptibleTemperature());
        }
    }

    private double calculatePerceptibleTemperature() {
        return nonNull(lastWindChange)
                ? this.lastTemperatureChange.getChange() - lastWindChange.getChange() * 0.05
                : lastTemperatureChange.getChange();
    }
}

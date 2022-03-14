package domain.observer.implementation;

import domain.eventbroker.Event;
import domain.observer.Observer;
import domain.observer.dto.TemperatureChange;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;

@Slf4j
public class AvgTemperatureObserver implements Observer {

    private static final int NUMBER_OF_TEMPERATURES_FOR_AVG = 5;

    private final List<TemperatureChange> lastChanges;

    public AvgTemperatureObserver() {
        this.lastChanges = new LinkedList<>();
    }

    @Override
    public synchronized void handle(Event<?> temperatureChangeEvent) {

        TemperatureChange temperatureChange = (TemperatureChange) temperatureChangeEvent.getEventBody();

        log.info("New temperature change: {}", temperatureChange);

        lastChanges.add(temperatureChange);

        while (lastChanges.size() > NUMBER_OF_TEMPERATURES_FOR_AVG) {
            lastChanges.remove(0);
        }

        double avg = lastChanges.stream()
                .mapToDouble(TemperatureChange::getChange)
                .sum() / NUMBER_OF_TEMPERATURES_FOR_AVG;

        log.info("Average for last {} temperatures is: {}", lastChanges.size(), avg);
    }
}

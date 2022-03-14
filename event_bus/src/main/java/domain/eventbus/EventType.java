package domain.eventbus;

import java.util.Objects;

public enum EventType {
    WIND_CHANGE, TEMPERATURE_CHANGE;

    public static boolean isTemperatureChange(EventType eventType) {
        return Objects.equals(eventType, TEMPERATURE_CHANGE);
    }
}

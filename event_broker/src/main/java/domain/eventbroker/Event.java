package domain.eventbroker;

import lombok.Value;

@Value
public class Event<T> {
    EventType eventType;
    T eventBody;
}

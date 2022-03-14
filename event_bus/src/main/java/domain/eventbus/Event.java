package domain.eventbus;

import lombok.Value;

@Value
public class Event<T> {
    EventType eventType;
    T eventBody;
}

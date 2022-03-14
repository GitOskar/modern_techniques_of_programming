package domain.model.message;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Message {

    private String message;
    private MessageType messageType;

    public void addAtTheBegin(String value) {
        message = value + message;
    }

    public void addAtTheEnd(String value) {
        message = message + value;
    }
}

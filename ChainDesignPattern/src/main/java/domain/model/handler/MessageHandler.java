package domain.model.handler;

import domain.model.message.Message;

public interface MessageHandler {

    void handle(Message message);
}

package domain.model.handler;

import domain.model.message.Message;

import static domain.model.message.MessageType.OTHER;
import static domain.model.message.MessageType.isOther;

public class OtherMessageHandler extends AbstractMessageHandler {

    public OtherMessageHandler() {
        this(null);
    }

    public OtherMessageHandler(MessageHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handle(Message message) {

        if (!isOther(message.getMessageType())) {
            message.addAtTheEnd(OTHER.getIfIsNot());
        }

        handleNext(message);
    }
}

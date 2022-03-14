package domain.model.handler;

import domain.model.message.Message;

import static domain.model.message.MessageType.SPAM;
import static domain.model.message.MessageType.isSpam;

public class SpamMessageHandler extends AbstractMessageHandler {

    public SpamMessageHandler() {
        this(null);
    }

    public SpamMessageHandler(MessageHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handle(Message message) {

        if (isSpam(message.getMessageType())) {
            message.addAtTheBegin(SPAM.getIfIs());
        } else {
            message.addAtTheEnd(SPAM.getIfIsNot());
        }

        handleNext(message);
    }
}

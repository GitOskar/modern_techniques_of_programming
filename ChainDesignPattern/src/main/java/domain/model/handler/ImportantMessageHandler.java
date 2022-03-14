package domain.model.handler;

import domain.model.message.Message;

import static domain.model.message.MessageType.IMPORTANT;
import static domain.model.message.MessageType.isImportant;

public class ImportantMessageHandler extends AbstractMessageHandler {

    public ImportantMessageHandler() {
        this(null);
    }

    public ImportantMessageHandler(MessageHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handle(Message message) {

        if (isImportant(message.getMessageType())) {
            message.addAtTheBegin(IMPORTANT.getIfIs());
        } else {
            message.addAtTheEnd(IMPORTANT.getIfIsNot());
        }

        handleNext(message);
    }
}

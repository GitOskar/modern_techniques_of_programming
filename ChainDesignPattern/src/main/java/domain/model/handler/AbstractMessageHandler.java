package domain.model.handler;

import domain.model.message.Message;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public abstract class AbstractMessageHandler implements MessageHandler {

    protected final MessageHandler nextHandler;

    protected final void handleNext(Message message) {
        Optional.ofNullable(nextHandler)
                .ifPresent(next -> next.handle(message));
    }
}

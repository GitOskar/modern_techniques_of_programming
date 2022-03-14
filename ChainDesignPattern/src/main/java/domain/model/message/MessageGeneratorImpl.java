package domain.model.message;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MessageGeneratorImpl implements MessageGenerator {

    private final MessageTypeGenerator messageTypeGenerator;

    @Override
    public Message generateMessage(String value) {
        return new Message(value, messageTypeGenerator.getRandomMessageType());
    }
}

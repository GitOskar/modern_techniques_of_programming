package domain.model.message;

import static domain.model.util.RandomUtil.getRandomValue;

public class MessageTypeGeneratorImpl implements MessageTypeGenerator {

    private static final MessageType[] ALL_MESSAGE_TYPE = MessageType.values();

    @Override
    public MessageType getRandomMessageType() {
        return ALL_MESSAGE_TYPE[getRandomValue(ALL_MESSAGE_TYPE.length)];
    }
}

package domain.model.handler

import domain.model.message.*
import spock.lang.Specification

class MessageHandlerChainTest extends Specification {

    MessageHandler handlerChain
    MessageTypeGenerator messageTypeGenerator = Mock(MessageTypeGenerator)
    MessageGenerator messageGenerator = new MessageGeneratorImpl(messageTypeGenerator)

    def setup() {
        handlerChain = new SpamMessageHandler(new ImportantMessageHandler(new OtherMessageHandler()))
    }

    def "should create correct message when message type is important"() {

        given:
        String text = "Ala has a cat. "
        messageTypeGenerator.getRandomMessageType() >> MessageType.IMPORTANT
        Message message = messageGenerator.generateMessage(text)

        when:
        handlerChain.handle(message)

        then:
        noExceptionThrown()
        message.getMessage() == "ATTENTION! THIS IS IMPORTANT. Ala has a cat. This is not spam. This is not message from other category. "
    }

    def "should create correct message when message type is spam"() {

        given:
        String text = "Ala has a cat. "
        messageTypeGenerator.getRandomMessageType() >> MessageType.SPAM
        Message message = messageGenerator.generateMessage(text)

        when:
        handlerChain.handle(message)

        then:
        noExceptionThrown()
        message.getMessage() == "ATTENTION! THIS IS SPAM. Ala has a cat. This is not important. This is not message from other category. "
    }

    def "should create correct message when message type is other"() {

        given:
        String text = "Ala has a cat. "
        messageTypeGenerator.getRandomMessageType() >> MessageType.OTHER
        Message message = messageGenerator.generateMessage(text)

        when:
        handlerChain.handle(message)

        then:
        noExceptionThrown()
        message.getMessage() == "Ala has a cat. This is not spam. This is not important. "
    }
}

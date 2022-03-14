package domain.model.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@Getter
@RequiredArgsConstructor
public enum MessageType {
    SPAM("ATTENTION! THIS IS SPAM. ", "This is not spam. "),
    IMPORTANT("ATTENTION! THIS IS IMPORTANT. ", "This is not important. "),
    OTHER("", "This is not message from other category. ");

    private final String ifIs;
    private final String ifIsNot;

    public static boolean isSpam(MessageType messageType) {
        return Objects.equals(messageType, SPAM);
    }

    public static boolean isImportant(MessageType messageType) {
        return Objects.equals(messageType, IMPORTANT);
    }

    public static boolean isOther(MessageType messageType) {
        return Objects.equals(messageType, OTHER);
    }
}

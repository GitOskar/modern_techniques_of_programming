package pl.umcs.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.nio.ByteBuffer;
import java.util.Base64;
import java.util.stream.IntStream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Base64Util {

    public static String convertToBase64(int[] intArray) {
        ByteBuffer buf = ByteBuffer.allocate(intArray.length);
        IntStream.of(intArray).forEach(i -> buf.put((byte)i));
        return Base64.getEncoder().encodeToString(buf.array());
    }
}

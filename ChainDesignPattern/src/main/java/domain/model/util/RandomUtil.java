package domain.model.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Random;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RandomUtil {

    private static final Random GENERATOR = new Random();

    public static int getRandomValue(int bound) {
        return GENERATOR.nextInt(bound);
    }
}

package domain.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Random;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RandomUtil {

    public static double nextDouble(double min, double max) {
        Random random = new Random();
        return min + (max - min) * random.nextDouble();
    }
}

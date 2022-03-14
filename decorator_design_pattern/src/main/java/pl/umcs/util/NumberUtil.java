package pl.umcs.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NumberUtil {

    public static boolean isDivisibleBy(int number, int divider) {
        return number % divider == 0;
    }

    public static boolean isNumberEven(int number) {
        return isDivisibleBy(number, 2);
    }
}

package pl.umcs.tax;

import java.math.BigDecimal;

public interface Tax {
    BigDecimal calculateTax(BigDecimal amount);
}
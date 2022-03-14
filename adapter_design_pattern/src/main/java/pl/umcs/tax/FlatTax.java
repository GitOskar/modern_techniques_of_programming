package pl.umcs.tax;

import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;

@RequiredArgsConstructor
public class FlatTax implements Tax {

    protected final BigDecimal flatTaxationPercentage;

    @Override
    public BigDecimal calculateTax(BigDecimal amount) {
        return amount
                .multiply(flatTaxationPercentage)
                .setScale(2, RoundingMode.HALF_UP);
    }
}

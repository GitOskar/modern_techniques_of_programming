package pl.umcs.tax;

import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;

@RequiredArgsConstructor
public class ProgressiveTax implements Tax {

    protected final BigDecimal flatTaxationPercentage;
    protected final BigDecimal progressiveTaxationPercentage;
    protected final BigDecimal borderAmount;

    @Override
    public BigDecimal calculateTax(BigDecimal amount) {

        return calculateFlatPart(amount)
                .add(calculateProgressivePart(amount))
                .setScale(2, RoundingMode.HALF_UP);
    }

    private BigDecimal calculateFlatPart(BigDecimal price) {
        if (price.compareTo(borderAmount) <= 0) {
            return price.multiply(flatTaxationPercentage);
        }
        else {
            return borderAmount.multiply(flatTaxationPercentage);
        }

    }

    private BigDecimal calculateProgressivePart(BigDecimal price) {
        if (price.compareTo(borderAmount) <= 0) {
            return BigDecimal.ZERO;
        }
        else {
            return price.subtract(borderAmount)
                    .multiply(progressiveTaxationPercentage);
        }
    }
}

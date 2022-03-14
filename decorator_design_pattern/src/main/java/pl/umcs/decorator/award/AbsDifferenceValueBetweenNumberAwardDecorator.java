package pl.umcs.decorator.award;

import pl.umcs.composite.HoldingCompanyComposite;
import pl.umcs.dto.BenefitCardDto;

import java.math.BigDecimal;

import static java.lang.Math.abs;
import static java.math.BigDecimal.ZERO;

public class AbsDifferenceValueBetweenNumberAwardDecorator extends AbstractHoldingCompanyAwardDecorator {

    private static final BigDecimal AWARD = BigDecimal.valueOf(200L);

    public AbsDifferenceValueBetweenNumberAwardDecorator(HoldingCompanyComposite holdingCompanyComposite) {
        super(holdingCompanyComposite);
    }

    @Override
    protected BigDecimal calculateAward(BenefitCardDto benefitCard) {

        int sumOfDifferences = 0;

        char[] numbers = benefitCard.getNip().toCharArray();

        for (int i = 1; i < numbers.length; i++) {
            sumOfDifferences += abs(numbers[i] - numbers[i - 1]);
        }

        return sumOfDifferences > 50 ? AWARD : ZERO;
    }
}

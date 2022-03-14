package pl.umcs.decorator.award;

import pl.umcs.composite.HoldingCompanyComposite;
import pl.umcs.dto.BenefitCardDto;
import pl.umcs.util.NumberUtil;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;

public class HalfDivisibleByThreeAwardDecorator extends AbstractHoldingCompanyAwardDecorator {

    private static final BigDecimal HALF_DIVISIBLE_BY_THREE_AWARD = BigDecimal.valueOf(100L);

    public HalfDivisibleByThreeAwardDecorator(HoldingCompanyComposite holdingCompanyComposite) {
        super(holdingCompanyComposite);
    }

    @Override
    protected BigDecimal calculateAward(BenefitCardDto benefitCard) {
        long countDivisibleByThree = benefitCard.getNip()
                .chars()
                .mapToObj(number -> (char) number)
                .map(Character::getNumericValue)
                .filter(this::isDivisibleByThree)
                .count();

        return countDivisibleByThree >= 5 ? HALF_DIVISIBLE_BY_THREE_AWARD : ZERO;
    }

    private boolean isDivisibleByThree(int number) {
        return NumberUtil.isDivisibleBy(number, 3);
    }
}

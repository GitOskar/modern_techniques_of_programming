package pl.umcs.decorator.award;

import pl.umcs.composite.HoldingCompanyComposite;
import pl.umcs.dto.BenefitCardDto;

import java.math.BigDecimal;
import java.time.LocalDate;

import static java.math.BigDecimal.ZERO;

public class SumOfNumbersEqualsSumOfDayAndMonthMultipliedByThreeAwardDecorator extends AbstractHoldingCompanyAwardDecorator {

    private static final BigDecimal AWARD = BigDecimal.valueOf(550L);

    public SumOfNumbersEqualsSumOfDayAndMonthMultipliedByThreeAwardDecorator(HoldingCompanyComposite holdingCompanyComposite) {
        super(holdingCompanyComposite);
    }

    @Override
    protected BigDecimal calculateAward(BenefitCardDto benefitCard) {
        return getActualDateValue() == calculateSumOfNumbers(benefitCard.getNip())
                ? AWARD
                : ZERO;
    }

    private int getActualDateValue() {
        LocalDate now = LocalDate.now();

        return (now.getMonthValue() + now.getDayOfMonth()) * 3;
    }

    private int calculateSumOfNumbers(String nip) {
        return nip.chars()
                .map(Character::getNumericValue)
                .sum();
    }
}
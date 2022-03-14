package pl.umcs.decorator.award;

import pl.umcs.composite.HoldingCompanyComposite;
import pl.umcs.dto.BenefitCardDto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.math.BigDecimal.ZERO;

public class ActualDayAwardDecorator extends AbstractHoldingCompanyAwardDecorator {

    private static final BigDecimal ACTUAL_DAY_AWARD = BigDecimal.valueOf(15L);
    private static final DateTimeFormatter ACTUAL_DAY_AWARD_PATTERN = DateTimeFormatter.ofPattern("MMdd");

    public ActualDayAwardDecorator(HoldingCompanyComposite holdingCompanyComposite) {
        super(holdingCompanyComposite);
    }

    @Override
    protected BigDecimal calculateAward(BenefitCardDto benefitCard) {

        String actualDay = LocalDate.now()
                .format(ACTUAL_DAY_AWARD_PATTERN);

        return benefitCard.getNip().contains(actualDay) ? ACTUAL_DAY_AWARD : ZERO;
    }
}

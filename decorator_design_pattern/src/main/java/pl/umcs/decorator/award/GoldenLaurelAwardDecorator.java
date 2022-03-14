package pl.umcs.decorator.award;

import pl.umcs.composite.HoldingCompanyComposite;
import pl.umcs.dto.BenefitCardDto;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;

public class GoldenLaurelAwardDecorator extends AbstractHoldingCompanyAwardDecorator {

    private static final BigDecimal AWARD = BigDecimal.valueOf(30L);
    private static final BigDecimal MIN_PROFIT_FOR_AWARD = BigDecimal.valueOf(100000L);

    public GoldenLaurelAwardDecorator(HoldingCompanyComposite holdingCompanyComposite) {
        super(holdingCompanyComposite);
    }

    @Override
    protected BigDecimal calculateAward(BenefitCardDto benefitCard) {
        BigDecimal totalProfit = benefitCard.getAnnualProfits()
                .stream()
                .reduce(ZERO, BigDecimal::add);

        return totalProfit.compareTo(MIN_PROFIT_FOR_AWARD) < 0
                ? ZERO
                : AWARD;
    }
}

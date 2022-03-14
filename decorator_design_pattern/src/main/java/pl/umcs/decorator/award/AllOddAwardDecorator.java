package pl.umcs.decorator.award;

import pl.umcs.composite.HoldingCompanyComposite;
import pl.umcs.dto.BenefitCardDto;
import pl.umcs.util.NumberUtil;

import java.math.BigDecimal;

public class AllOddAwardDecorator extends AbstractHoldingCompanyAwardDecorator {

    private static final BigDecimal ALL_ODD_AWARD = BigDecimal.valueOf(50L);

    public AllOddAwardDecorator(HoldingCompanyComposite holdingCompanyComposite) {
        super(holdingCompanyComposite);
    }

    @Override
    protected BigDecimal calculateAward(BenefitCardDto benefitCardDto) {
        return benefitCardDto.getNip()
                .chars()
                .mapToObj(number -> (char) number)
                .map(Character::getNumericValue)
                .filter(NumberUtil::isNumberEven)
                .findFirst()
                .map(number -> BigDecimal.ZERO)
                .orElse(ALL_ODD_AWARD);
    }
}

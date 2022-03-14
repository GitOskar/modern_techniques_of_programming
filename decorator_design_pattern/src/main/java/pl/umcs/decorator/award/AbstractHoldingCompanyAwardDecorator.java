package pl.umcs.decorator.award;

import lombok.RequiredArgsConstructor;
import pl.umcs.composite.HoldingCompanyComposite;
import pl.umcs.dto.BenefitCardDto;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
public abstract class AbstractHoldingCompanyAwardDecorator implements HoldingCompanyComposite {

    private final HoldingCompanyComposite holdingCompanyComposite;

    @Override
    public final List<BenefitCardDto> getBenefitCards() {
        List<BenefitCardDto> benefitCards = holdingCompanyComposite.getBenefitCards();

        benefitCards.forEach(benefitCard -> benefitCard.addAward(calculateAward(benefitCard)));

        return benefitCards;
    }

    protected abstract BigDecimal calculateAward(BenefitCardDto benefitCard);
}

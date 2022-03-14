package pl.umcs.decorator.award;

import org.junit.jupiter.api.Test;
import pl.umcs.HoldingCompany;
import pl.umcs.composite.HoldingCompanyComposite;
import pl.umcs.dto.BenefitCardDto;

import java.math.BigDecimal;
import java.util.List;

import static java.math.BigDecimal.ZERO;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AllOddAwardDecoratorTest {

    private static final BigDecimal AWARD = BigDecimal.valueOf(50L);

    @Test
    public void shouldCorrectlyCalculateAllOddAward() {

        //given
        HoldingCompany firstWithAward = new HoldingCompany("First with award", null, "1357913579", null, null, null, emptyList());
        HoldingCompany secondWithAward = new HoldingCompany("Second with award", null, "1111111111", null, null, null, singletonList(firstWithAward));
        HoldingCompany firstWithoutAward = new HoldingCompany("First without award", null, "2222222222", null, null, null, emptyList());
        HoldingCompany secondWithoutAward = new HoldingCompany("Second without award", null, "1234567891", null, null, null, asList(firstWithoutAward, secondWithAward));
        HoldingCompanyComposite decorator = new AllOddAwardDecorator(secondWithoutAward);

        //when
        List<BenefitCardDto> benefitCards = decorator.getBenefitCards();

        //then
        assertEquals(benefitCards.size(), 4);
        assertTrue(benefitCards.containsAll(expectedCards()));
    }

    private static List<BenefitCardDto> expectedCards() {
        return asList(
                new BenefitCardDto("First with award", "1357913579", null, AWARD),
                new BenefitCardDto("Second with award", "1111111111", null, AWARD),
                new BenefitCardDto("First without award", "2222222222", null, ZERO),
                new BenefitCardDto("Second without award", "1234567891", null, ZERO)
        );
    }
}
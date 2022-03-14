package pl.umcs.decorator.award;

import org.junit.jupiter.api.Test;
import pl.umcs.HoldingCompany;
import pl.umcs.composite.HoldingCompanyComposite;
import pl.umcs.dto.BenefitCardDto;

import java.math.BigDecimal;
import java.util.List;

import static java.math.BigDecimal.ZERO;
import static java.math.BigDecimal.valueOf;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HalfDivisibleByThreeAwardDecoratorTest {

    private static final BigDecimal AWARD = valueOf(100L);

    @Test
    public void shouldCorrectlyCalculateDivisibleByThreeAwards() {

        //given
        HoldingCompany firstWithAward = new HoldingCompany("First with award", null, "3461923162", null, null, null, emptyList());
        HoldingCompany secondWithAward = new HoldingCompany("Second with award", null, "3333333333", null, null, null, singletonList(firstWithAward));
        HoldingCompany firstWithoutAward = new HoldingCompany("First without award", null, "3699124578", null, null, null, emptyList());
        HoldingCompany secondWithoutAward = new HoldingCompany("Second without award", null, "1234567891", null, null, null, asList(firstWithoutAward, secondWithAward));
        HoldingCompanyComposite decorator = new HalfDivisibleByThreeAwardDecorator(secondWithoutAward);

        //when
        List<BenefitCardDto> benefitCards = decorator.getBenefitCards();

        //then
        assertEquals(benefitCards.size(), 4);
        assertTrue(benefitCards.containsAll(expectedCards()));
    }

    private static List<BenefitCardDto> expectedCards() {
        return asList(
                new BenefitCardDto("First with award", "3461923162", null, AWARD),
                new BenefitCardDto("Second with award", "3333333333", null, AWARD),
                new BenefitCardDto("First without award", "3699124578",null, ZERO),
                new BenefitCardDto("Second without award", "1234567891",null, ZERO)
        );
    }
}
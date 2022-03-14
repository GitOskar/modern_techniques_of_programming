package pl.umcs;

import lombok.extern.slf4j.Slf4j;
import pl.umcs.composite.HoldingCompanyComposite;
import pl.umcs.decorator.award.*;
import pl.umcs.dto.BenefitCardDto;

import java.util.List;

import static java.math.BigDecimal.valueOf;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

@Slf4j
public class DecoratorPresentation {

    public static void main(String[] args) {
        HoldingCompany first = new HoldingCompany("First company", "Cwiartki 3/4", "1357913579", asList(valueOf(50000L), valueOf(50000L)), singletonList(valueOf(300000L)), singletonList("Json"), emptyList());
        HoldingCompany second = new HoldingCompany("Second company", "Kleeberga 8", "1111111111", singletonList(valueOf(300000L)), singletonList(valueOf(400000L)), singletonList("Jacek"), singletonList(first));
        HoldingCompany third = new HoldingCompany("Third company", "Baluty", "2222222222", asList(valueOf(50000L), valueOf(49999L)), singletonList(valueOf(500000L)), singletonList("Jenkins"), emptyList());
        HoldingCompanyComposite main = new HoldingCompany("Fourth company", "Krakowskie przedmiescia", "1234567891", singletonList(valueOf(30000L)), singletonList(valueOf(600000L)), singletonList("Placek"), asList(third, second));

        HoldingCompanyComposite decorator = new AbsDifferenceValueBetweenNumberAwardDecorator(
                new ActualDayAwardDecorator(
                        new AllOddAwardDecorator(
                                new GoldenLaurelAwardDecorator(
                                        new HalfDivisibleByThreeAwardDecorator(
                                                new SumOfNumbersEqualsSumOfDayAndMonthMultipliedByThreeAwardDecorator(main))))));

        List<BenefitCardDto> benefitCards = decorator.getBenefitCards();

        log.info("Benefit cards: {}", benefitCards);
    }
}

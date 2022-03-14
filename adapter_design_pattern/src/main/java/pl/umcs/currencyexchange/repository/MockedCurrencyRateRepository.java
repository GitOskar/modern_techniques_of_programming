package pl.umcs.currencyexchange.repository;

import com.neovisionaries.i18n.CurrencyCode;
import pl.umcs.currencyexchange.CurrencyRateDto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static com.neovisionaries.i18n.CurrencyCode.*;

public class MockedCurrencyRateRepository implements CurrencyRateRepository {

    private List<CurrencyRateDto> currencyRates;

    public MockedCurrencyRateRepository() {
        this.currencyRates = Arrays.asList(CurrencyRateDto.of(PLN, EUR, BigDecimal.ONE
                        .divide(BigDecimal.valueOf(4.2), 2, RoundingMode.HALF_UP)),
                CurrencyRateDto.of(USD, EUR, BigDecimal.valueOf(3)
                        .divide(BigDecimal.valueOf(3.8), 2, RoundingMode.HALF_UP)),
                CurrencyRateDto.of(EUR, EUR, BigDecimal.ONE));
    }

    @Override
    public CurrencyRateDto getCurrencyRate(CurrencyCode from, CurrencyCode to) {
        return currencyRates.stream()
                .filter(currencyRate -> Objects.equals(currencyRate.getFrom(), from) && Objects.equals(currencyRate.getTo(), to))
                .findFirst()
                .orElseThrow(() -> new UnsupportedOperationException("Currency not supported"));
    }
}
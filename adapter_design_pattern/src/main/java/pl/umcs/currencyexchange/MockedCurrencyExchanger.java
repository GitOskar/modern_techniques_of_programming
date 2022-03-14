package pl.umcs.currencyexchange;

import com.neovisionaries.i18n.CurrencyCode;
import pl.umcs.currencyexchange.repository.CurrencyRateRepository;
import pl.umcs.currencyexchange.repository.MockedCurrencyRateRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MockedCurrencyExchanger implements CurrencyExchanger {

    private final CurrencyRateRepository currencyRateRepository;

    public MockedCurrencyExchanger() {
        this.currencyRateRepository = new MockedCurrencyRateRepository();
    }

    @Override
    public BigDecimal exchange(BigDecimal value, CurrencyCode from, CurrencyCode to) {
        CurrencyRateDto currencyRate = currencyRateRepository.getCurrencyRate(from, to);

        return value.multiply(currencyRate.getCurrencyRate())
                .setScale(2, RoundingMode.HALF_UP);
    }
}
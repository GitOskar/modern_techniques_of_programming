package pl.umcs.currencyexchange.repository;

import com.neovisionaries.i18n.CurrencyCode;
import pl.umcs.currencyexchange.CurrencyRateDto;

public interface CurrencyRateRepository {
    CurrencyRateDto getCurrencyRate(CurrencyCode from, CurrencyCode to);
}

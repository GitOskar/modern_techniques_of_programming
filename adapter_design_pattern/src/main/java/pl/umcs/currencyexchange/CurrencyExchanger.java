package pl.umcs.currencyexchange;

import com.neovisionaries.i18n.CurrencyCode;

import java.math.BigDecimal;

public interface CurrencyExchanger {
    BigDecimal exchange(BigDecimal value, CurrencyCode from, CurrencyCode to);
}

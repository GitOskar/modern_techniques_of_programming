package pl.umcs.currencyexchange;

import com.neovisionaries.i18n.CurrencyCode;
import lombok.Value;

import java.math.BigDecimal;

@Value(staticConstructor = "of")
public class CurrencyRateDto {

    CurrencyCode from;
    CurrencyCode to;
    BigDecimal currencyRate;
}

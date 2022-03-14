package pl.umcs.currencyexchange;

import com.neovisionaries.i18n.CountryCode;
import com.neovisionaries.i18n.CurrencyCode;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CurrencyUtils {

    public static CurrencyCode currencyCodeFromCountryCode(CountryCode countryCode) {
        return CurrencyCode.valueOf(countryCode.getCurrency()
                .getCurrencyCode());
    }
}
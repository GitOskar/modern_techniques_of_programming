package pl.umcs.tax.factory;

import com.neovisionaries.i18n.CountryCode;
import pl.umcs.tax.FlatTax;
import pl.umcs.tax.ProgressiveTax;
import pl.umcs.tax.Tax;

import java.math.BigDecimal;

public class TaxFactory {

    protected final FlatTax polishTax;
    protected final FlatTax usaTax;
    protected final ProgressiveTax frenchTax;
    protected final ProgressiveTax germanyTax;

    public TaxFactory() {
        this.polishTax = new FlatTax(BigDecimal.valueOf(0.19));
        this.usaTax = new FlatTax(BigDecimal.valueOf(0.1));
        this.frenchTax = new ProgressiveTax(BigDecimal.valueOf(0.3),
                BigDecimal.valueOf(0.5),
                BigDecimal.valueOf(40000L));
        this.germanyTax = new ProgressiveTax(BigDecimal.valueOf(0.2),
                BigDecimal.valueOf(0.4),
                BigDecimal.valueOf(50000L));
    }

    public Tax getTax(CountryCode countryCode) {
        switch (countryCode) {
            case PL:
                return polishTax;
            case US:
                return usaTax;
            case FR:
                return frenchTax;
            case GR:
                return germanyTax;
            default:
                throw new UnsupportedOperationException("Unsupported country code");
        }
    }
}
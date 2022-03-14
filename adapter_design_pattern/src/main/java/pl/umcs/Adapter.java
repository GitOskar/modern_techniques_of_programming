package pl.umcs;

import com.neovisionaries.i18n.CountryCode;
import com.neovisionaries.i18n.CurrencyCode;
import com.sun.tools.javac.util.Pair;
import lombok.AllArgsConstructor;
import pl.umcs.currencyexchange.CurrencyExchanger;
import pl.umcs.tax.Tax;
import pl.umcs.tax.factory.TaxFactory;
import pl.umcs.warehouse.Warehouse;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static pl.umcs.currencyexchange.CurrencyUtils.currencyCodeFromCountryCode;

@AllArgsConstructor
public class Adapter {

    private final Warehouse warehouse;
    private final CurrencyExchanger currencyExchanger;

    public List<Pair<CountryCode, BigDecimal>> getTaxesValues() {

        List<Pair<CountryCode, Tax>> taxes = prepareTaxes();

        BigDecimal sumOfAmounts = warehouse.calculateSumOfAmountsWithoutTax();

        return taxes.stream()
                    .map(tax -> Pair.of(tax.fst, tax.snd
                            .calculateTax(exchangeToEur(sumOfAmounts, currencyCodeFromCountryCode(tax.fst)))))
                    .collect(toList());
    }

    private List<Pair<CountryCode, Tax>> prepareTaxes() {
        TaxFactory taxFactory = new TaxFactory();

        return Arrays.asList(
                Pair.of(CountryCode.PL, taxFactory.getTax(CountryCode.PL)),
                Pair.of(CountryCode.US, taxFactory.getTax(CountryCode.US)),
                Pair.of(CountryCode.FR, taxFactory.getTax(CountryCode.FR)),
                Pair.of(CountryCode.GR, taxFactory.getTax(CountryCode.GR))
        );
    }

    private BigDecimal exchangeToEur(BigDecimal value, CurrencyCode from) {
        return currencyExchanger.exchange(value, from, CurrencyCode.EUR);
    }

    private BigDecimal exchangeFromEur(BigDecimal value, CurrencyCode to) {
        return currencyExchanger.exchange(value, CurrencyCode.EUR, to);
    }
}
package pl.umcs.currencyexchange.factory;

import pl.umcs.currencyexchange.CurrencyExchanger;
import pl.umcs.currencyexchange.MockedCurrencyExchanger;

public class CurrencyExchangerFactory {

    private final MockedCurrencyExchanger mockedCurrencyExchanger;

    public CurrencyExchangerFactory() {
        this.mockedCurrencyExchanger = new MockedCurrencyExchanger();
    }



    public CurrencyExchanger getCurrencyExchanger(CurrencyExchangeStrategyType type) {
        switch (type) {
            case MOCKED:
                return mockedCurrencyExchanger;
            default:
                throw new UnsupportedOperationException("Currency exchange strategy not supported");
        }
    }
}

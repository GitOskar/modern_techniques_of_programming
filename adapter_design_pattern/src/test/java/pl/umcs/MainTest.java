package pl.umcs;

import com.neovisionaries.i18n.CountryCode;
import com.sun.tools.javac.util.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.umcs.currencyexchange.MockedCurrencyExchanger;
import pl.umcs.item.Book;
import pl.umcs.item.Painting;
import pl.umcs.item.Sculpture;
import pl.umcs.item.base.Item;
import pl.umcs.tax.FlatTax;
import pl.umcs.tax.ProgressiveTax;
import pl.umcs.tax.Tax;
import pl.umcs.tax.factory.TaxFactory;
import pl.umcs.warehouse.Warehouse;

import java.math.BigDecimal;
import java.time.Year;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MainTest {

    private final TaxFactory taxFactory = new TaxFactory();

    @Test
    public void partOneTest() {
        Warehouse warehouse = new Warehouse(prepareItemList());

        Tax flatTax = new FlatTax(BigDecimal.valueOf(0.19));
        Tax progressiveTax = new ProgressiveTax(BigDecimal.valueOf(0.18),
                BigDecimal.valueOf(0.32),
                BigDecimal.valueOf(10000));

        assertEquals(warehouse.calculateSumOfAmountsWithoutTax(), BigDecimal.valueOf(19360.17));
        assertEquals(warehouse.calculateSumOfAmountsWithTax(flatTax), BigDecimal.valueOf(15681.74));
        assertEquals(warehouse.calculateSumOfAmountsWithTax(progressiveTax), BigDecimal.valueOf(14564.92));
    }

    @Test
    public void partTwoTest() {
        Tax usaTax = taxFactory.getTax(CountryCode.US);
        Tax polishTax = taxFactory.getTax(CountryCode.PL);
        Tax frenchTax = taxFactory.getTax(CountryCode.FR);
        Tax germanTax = taxFactory.getTax(CountryCode.GR);

        assertNotNull(usaTax);
        assertNotNull(polishTax);
        assertNotNull(frenchTax);
        assertNotNull(germanTax);
    }

    @Test
    public void partThreeTest() {

        Warehouse warehouse = new Warehouse(prepareItemList());

        Adapter adapter = new Adapter(warehouse, new MockedCurrencyExchanger());

        List<Pair<CountryCode, BigDecimal>> taxesValues = adapter.getTaxesValues();

        assertEquals(taxesValues.size(), 4);
        taxesValues.forEach(Assertions::assertNotNull);
    }

    List<Item> prepareItemList() {
        return Arrays.asList(
                new Book(Year.of(1999), 2),
                new Book(Year.of(2006), 3),
                new Painting(Year.of(1800)),
                new Painting(Year.of(1900)),
                new Sculpture(Year.of(1500), BigDecimal.valueOf(3)),
                new Sculpture(Year.of(900), BigDecimal.valueOf(5)));
    }
}

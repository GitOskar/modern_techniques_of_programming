package pl.umcs.item;

import pl.umcs.item.base.WorkOfArt;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Year;

public class Book extends WorkOfArt {

    protected final long issueNumber;
    protected final BigDecimal price;

    public Book(Year creationYear, long issueNumber) {
        super(creationYear);
        this.issueNumber = issueNumber;
        this.price = calculatePrice();
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal calculatePrice() {
        return BigDecimal.valueOf(2050L)
                .subtract(BigDecimal.valueOf(creationYear.getValue()))
                .divide(BigDecimal.valueOf(issueNumber), 2, RoundingMode.HALF_UP)
                .setScale(2, RoundingMode.HALF_UP);
    }
}
package pl.umcs.item;

import pl.umcs.item.base.WorkOfArt;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Year;

public class Painting extends WorkOfArt {

    protected final BigDecimal price;

    public Painting(Year creationYear) {
        super(creationYear);
        price = calculatePrice();
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    private BigDecimal calculatePrice() {
        return BigDecimal.valueOf(2100L)
                .subtract(BigDecimal.valueOf(creationYear.getValue()))
                .movePointRight(1)
                .setScale(2, RoundingMode.HALF_UP);
    }
}

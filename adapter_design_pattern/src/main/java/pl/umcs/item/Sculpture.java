package pl.umcs.item;

import pl.umcs.item.base.WorkOfArt;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Year;

public class Sculpture extends WorkOfArt {

    protected final BigDecimal volumeInCubicMeters;
    protected final BigDecimal price;

    public Sculpture(Year creationYear, BigDecimal volumeInCubicMeters) {
        super(creationYear);
        this.volumeInCubicMeters = volumeInCubicMeters;
        this.price = calculatePrice();
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    private BigDecimal calculatePrice() {
        return BigDecimal.valueOf(2020L)
                .subtract(BigDecimal.valueOf(creationYear.getValue()))
                .multiply(volumeInCubicMeters)
                .multiply(BigDecimal.valueOf(2L))
                .setScale(2, RoundingMode.HALF_UP);
    }
}

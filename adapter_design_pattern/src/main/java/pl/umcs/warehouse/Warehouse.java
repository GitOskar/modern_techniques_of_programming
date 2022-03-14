package pl.umcs.warehouse;

import lombok.AllArgsConstructor;
import pl.umcs.item.base.Item;
import pl.umcs.tax.Tax;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Warehouse {

    private final List<Item> itemList;

    public Warehouse() {
        this.itemList = new ArrayList<>();
    }

    public void addToList(Item item) {
        this.itemList.add(item);
    }

    public void addToList(List<Item> itemList) {
        itemList.forEach(this::addToList);
    }

    public BigDecimal calculateSumOfAmountsWithoutTax() {
        return itemList.stream()
                .map(Item::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal calculateSumOfAmountsWithTax(Tax tax) {

        BigDecimal sum = calculateSumOfAmountsWithoutTax();

        return sum.subtract(tax.calculateTax(sum));
    }
}
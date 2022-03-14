package pl.umcs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class BenefitCardDto {

    private final String name;
    private final String nip;
    private final List<BigDecimal> annualProfits;
    private BigDecimal totalValue;

    public void addAward(BigDecimal awardValue) {
        totalValue = totalValue.add(awardValue);
    }
}
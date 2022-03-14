package pl.umcs.composite;

import pl.umcs.dto.BenefitCardDto;

import java.util.List;

public interface HoldingCompanyComposite {
    List<BenefitCardDto> getBenefitCards();
}
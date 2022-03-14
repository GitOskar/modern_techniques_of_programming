package pl.umcs;

import lombok.Value;
import pl.umcs.composite.HoldingCompanyComposite;
import pl.umcs.dto.BenefitCardDto;
import pl.umcs.visitor.CompanyVisitor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Value
public class HoldingCompany implements HoldingCompanyComposite {

    String name;
    String address;
    String nip;
    List<BigDecimal> annualProfits;
    List<BigDecimal> annualIncomes;
    List<String> contrahentNames;
    List<HoldingCompany> subordinateCompanies;

    @Override
    public List<BenefitCardDto> getBenefitCards() {
        List<BenefitCardDto> benefitCardDtos = new ArrayList<>();

        benefitCardDtos.add(new BenefitCardDto(name, nip, annualProfits, BigDecimal.ZERO));

        subordinateCompanies.forEach(holdingCompany -> benefitCardDtos.addAll(holdingCompany.getBenefitCards()));

        return benefitCardDtos;
    }

    public String acceptVisitor(CompanyVisitor companyVisitor) {
        return companyVisitor.visitHoldingCompany(this);
    }
}
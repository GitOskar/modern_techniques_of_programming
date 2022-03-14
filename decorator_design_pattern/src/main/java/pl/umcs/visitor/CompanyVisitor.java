package pl.umcs.visitor;

import pl.umcs.HoldingCompany;

public interface CompanyVisitor {
    String visitHoldingCompany(HoldingCompany holdingCompany);
}

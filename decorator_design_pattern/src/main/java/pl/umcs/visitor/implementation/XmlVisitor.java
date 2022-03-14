package pl.umcs.visitor.implementation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import pl.umcs.HoldingCompany;
import pl.umcs.visitor.CompanyVisitor;

public class XmlVisitor implements CompanyVisitor {

    @Override
    public String visitHoldingCompany(HoldingCompany holdingCompany) {
        try {
            return new XmlMapper()
                    .writeValueAsString(holdingCompany);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }
}

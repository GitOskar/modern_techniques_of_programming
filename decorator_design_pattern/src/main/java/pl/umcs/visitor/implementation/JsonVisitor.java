package pl.umcs.visitor.implementation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import pl.umcs.HoldingCompany;
import pl.umcs.visitor.CompanyVisitor;

public class JsonVisitor implements CompanyVisitor {

    @Override
    public String visitHoldingCompany(HoldingCompany holdingCompany) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.serializeNulls();
        Gson gson = gsonBuilder.create();
        return gson.toJson(holdingCompany);
    }
}
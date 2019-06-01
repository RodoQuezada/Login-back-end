package com.integracionsistema.perfilamiento.api.backend.view.xml;

import com.integracionsistema.perfilamiento.api.backend.models.entity.Company;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

//@XmlRootElement(name = "companies")
public class CompanyList {

  //  @XmlElement(name = "company")
    public List<Company> companies;

    public CompanyList() {
    }

    public CompanyList(List<Company> companies) {
        this.companies = companies;
    }

    public List<Company> getCompanies() {
        return companies;
    }
}

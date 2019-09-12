package com.integracionsistema.perfilamiento.api.backend.controller;

import com.integracionsistema.perfilamiento.api.backend.models.entity.Company;
import com.integracionsistema.perfilamiento.api.backend.models.services.ICompanyServices;
import com.integracionsistema.perfilamiento.api.backend.view.xml.CompanyList;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/api/company")
public class CompanyController {

    private final ICompanyServices companyServices;

    public CompanyController(ICompanyServices companyServices) {
        this.companyServices = companyServices;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody CompanyList getAll(){
        return new CompanyList(companyServices.findAll());
    }

    @GetMapping("/load")
    @Secured("ROLE_ADMIN")
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody CompanyList load(){

        Company company = new Company();
        company.setId(1l);
        company.setAddress("aaa");
        company.setName("aaa");

        Company company2 = new Company();
        company2.setId(2l);
        company2.setAddress("bbbb");
        company2.setName("bbb");

        companyServices.save(company);
        companyServices.save(company2);

        return new CompanyList(companyServices.findAll());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Company save(@RequestBody @Valid Company company){
        return companyServices.save(company);
    }






}

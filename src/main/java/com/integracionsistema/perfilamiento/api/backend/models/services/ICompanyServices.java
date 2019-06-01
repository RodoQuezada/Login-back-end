package com.integracionsistema.perfilamiento.api.backend.models.services;

import com.integracionsistema.perfilamiento.api.backend.models.entity.Company;

import java.util.List;

public interface ICompanyServices {

    List<Company> findAll();
    Company save(Company company);

}

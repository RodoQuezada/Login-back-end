package com.integracionsistema.perfilamiento.api.backend.models.services.impl;

import com.integracionsistema.perfilamiento.api.backend.models.entity.Company;
import com.integracionsistema.perfilamiento.api.backend.models.repository.ICompanyRepository;
import com.integracionsistema.perfilamiento.api.backend.models.services.ICompanyServices;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompanyServiceImpl implements ICompanyServices {

    private final ICompanyRepository companyRepository;

    public CompanyServiceImpl(ICompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    @Transactional
    public Company save(Company company) {
        return companyRepository.save(company);
    }
}

package com.integracionsistema.perfilamiento.api.backend.models.repository;

import com.integracionsistema.perfilamiento.api.backend.models.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompanyRepository extends JpaRepository<Company, Long> {
}

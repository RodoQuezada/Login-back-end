package com.integracionsistema.perfilamiento.api.backend.models.repository;

import com.integracionsistema.perfilamiento.api.backend.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long > {

    public User findByUsername(String username);

}

package com.integracionsistema.perfilamiento.api.backend.models.services;

import com.integracionsistema.perfilamiento.api.backend.models.entity.Cliente;

import java.util.List;

public interface IClienteServices {

    List<Cliente> getAll();
    Cliente save(Cliente cliente);
    Cliente findById(Long id);
    Cliente findClienteByRut(String rut);

}

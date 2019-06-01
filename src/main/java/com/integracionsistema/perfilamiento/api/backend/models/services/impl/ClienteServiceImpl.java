package com.integracionsistema.perfilamiento.api.backend.models.services.impl;

import com.integracionsistema.perfilamiento.api.backend.models.entity.Cliente;
import com.integracionsistema.perfilamiento.api.backend.models.repository.IClienteRepository;
import com.integracionsistema.perfilamiento.api.backend.models.services.IClienteServices;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteServices {

    private final IClienteRepository clienteRepository;

    public ClienteServiceImpl(IClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    @Override
    @Transactional
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findClienteByRut(String rut) {
        return clienteRepository.findClienteByRut(rut);
    }
}

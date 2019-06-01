package com.integracionsistema.perfilamiento.api.backend.models.entity.list;

import com.integracionsistema.perfilamiento.api.backend.models.entity.Cliente;

import java.util.List;

public class ClienteList {

    private List<Cliente> clientes;

    public ClienteList() {
    }

    public ClienteList(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
}

package com.integracionsistema.perfilamiento.api.backend.controller;

import com.integracionsistema.perfilamiento.api.backend.models.entity.Cliente;
import com.integracionsistema.perfilamiento.api.backend.models.entity.list.ClienteList;
import com.integracionsistema.perfilamiento.api.backend.models.services.IClienteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Encoder;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/api/cliente")
public class ClienteController {

    private final IClienteServices clienteServices;

    public ClienteController(IClienteServices clienteServices) {
        this.clienteServices = clienteServices;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody ClienteList getAll(){
        return new ClienteList(clienteServices.getAll());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody Cliente save(@RequestBody @Valid Cliente cliente){
        return clienteServices.save(cliente);
    }

    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Cliente findById(@PathVariable(value = "id")Long id){
        return clienteServices.findById(id);
    }

    @GetMapping("/rut/{rut}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Cliente findByRut(@PathVariable(value = "rut")String rut){
        return clienteServices.findClienteByRut(rut);
    }



}

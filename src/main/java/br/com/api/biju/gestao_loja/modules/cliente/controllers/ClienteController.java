package br.com.api.biju.gestao_loja.modules.cliente.controllers;

import br.com.api.biju.gestao_loja.modules.cliente.models.ClienteEntity;
import br.com.api.biju.gestao_loja.modules.cliente.repositories.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping("/")
    public ClienteEntity create(@Valid @RequestBody ClienteEntity clienteEntity){
        return this.clienteRepository.save(clienteEntity);
    }
}

package br.com.api.biju.gestao_loja.modules.cliente.controllers;

import br.com.api.biju.gestao_loja.modules.cliente.ClienteEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/cliente")
public class ClienteController {

    @PostMapping("/")
    public void create(@Valid @RequestBody ClienteEntity clienteEntity){
        System.out.println("Objeto: " +clienteEntity.getName());
    }
}

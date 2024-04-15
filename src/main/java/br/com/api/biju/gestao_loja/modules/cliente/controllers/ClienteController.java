package br.com.api.biju.gestao_loja.modules.cliente.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/cliente")
public class ClienteController {

    @PostMapping("/")
    public void create(){

    }
}

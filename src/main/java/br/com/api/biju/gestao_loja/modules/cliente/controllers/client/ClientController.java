package br.com.api.biju.gestao_loja.modules.cliente.controllers.client;

import br.com.api.biju.gestao_loja.modules.cliente.models.cliente.ClientEntity;
import br.com.api.biju.gestao_loja.modules.cliente.useCases.cliente.CreateClientUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/cliente")
public class ClientController {

    @Autowired
    private CreateClientUseCase createClientUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody ClientEntity clientEntity){
        try {
            var response = this.createClientUseCase.execute(clientEntity);
            return ResponseEntity.ok().body(response);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

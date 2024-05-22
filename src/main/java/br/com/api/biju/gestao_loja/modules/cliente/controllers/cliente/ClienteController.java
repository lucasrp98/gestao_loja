package br.com.api.biju.gestao_loja.modules.cliente.controllers.cliente;

import br.com.api.biju.gestao_loja.modules.cliente.models.cliente.ClienteEntity;
import br.com.api.biju.gestao_loja.modules.cliente.useCases.cliente.CreateClienteUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private CreateClienteUseCase createClienteUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody ClienteEntity clienteEntity){
        try {
            var response = this.createClienteUseCase.execute(clienteEntity);
            return ResponseEntity.ok().body(response);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

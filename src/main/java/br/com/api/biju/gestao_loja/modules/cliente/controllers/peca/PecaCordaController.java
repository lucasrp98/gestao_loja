package br.com.api.biju.gestao_loja.modules.cliente.controllers.peca;

import br.com.api.biju.gestao_loja.modules.cliente.models.peca.PecaCordaEntity;
import br.com.api.biju.gestao_loja.modules.cliente.useCases.peca.CreatePecaCordaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pecacorda")
public class PecaCordaController {

    @Autowired
    private CreatePecaCordaUseCase createPecaUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody PecaCordaEntity pecaCordaEntity) {
        try {
            var response = this.createPecaUseCase.execute(pecaCordaEntity);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}

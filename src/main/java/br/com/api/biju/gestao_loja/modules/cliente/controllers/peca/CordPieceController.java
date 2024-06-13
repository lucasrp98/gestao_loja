package br.com.api.biju.gestao_loja.modules.cliente.controllers.peca;

import br.com.api.biju.gestao_loja.modules.cliente.models.peca.CordPieceEntity;
import br.com.api.biju.gestao_loja.modules.cliente.useCases.peca.CreatePieceUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pecacorda")
public class CordPieceController {

    @Autowired
    private CreatePieceUseCase createPieceUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody CordPieceEntity cordPieceEntity) {
        try {
            var response = this.createPieceUseCase.execute(cordPieceEntity);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}

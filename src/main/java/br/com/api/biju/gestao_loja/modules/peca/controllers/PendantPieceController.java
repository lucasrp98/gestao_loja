package br.com.api.biju.gestao_loja.modules.peca.controllers;

import br.com.api.biju.gestao_loja.modules.peca.models.PendantPieceEntity;
import br.com.api.biju.gestao_loja.modules.peca.usecases.CreatePieceUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pecapingente")
public class PendantPieceController {

    @Autowired
    CreatePieceUseCase createPieceUseCase;

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody PendantPieceEntity pecaPingenteEntity) {
        try {
            var response = this.createPieceUseCase.execute(pecaPingenteEntity);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}

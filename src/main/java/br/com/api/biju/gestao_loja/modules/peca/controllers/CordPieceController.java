package br.com.api.biju.gestao_loja.modules.peca.controllers;

import br.com.api.biju.gestao_loja.modules.peca.dto.CordPieceCreateDTO;
import br.com.api.biju.gestao_loja.modules.peca.models.CordPieceEntity;
import br.com.api.biju.gestao_loja.modules.peca.models.PieceEntity;
import br.com.api.biju.gestao_loja.modules.peca.usecases.CreatePieceUseCase;
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
    public ResponseEntity<Object> create(@RequestBody CordPieceCreateDTO cordPieceCreateDTO) {
        try {
            PieceEntity pieceEntity = cordPieceCreateDTO.toCordPieceEntity();
            var response = this.createPieceUseCase.execute(pieceEntity);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}

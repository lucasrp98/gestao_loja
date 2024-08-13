package br.com.api.biju.gestao_loja.modules.people.seller.controllers;

import br.com.api.biju.gestao_loja.modules.people.seller.dto.SellerCreateDTO;
import br.com.api.biju.gestao_loja.modules.people.seller.models.SellerEntity;
import br.com.api.biju.gestao_loja.modules.people.seller.useCases.CreateSellerUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vendedor")
public class SellerController {
    @Autowired
    private CreateSellerUseCase createSellerUseCase;

    @PostMapping("/create")
    public ResponseEntity<Object> create(@Valid @RequestBody SellerCreateDTO sellerCreateDTO){
        try {
            SellerEntity sellerEntity = sellerCreateDTO.toSellerEntity();
            var response = this.createSellerUseCase.execute(sellerEntity);
            return ResponseEntity.ok().body(response);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

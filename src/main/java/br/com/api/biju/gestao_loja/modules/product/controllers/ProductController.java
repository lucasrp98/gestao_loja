package br.com.api.biju.gestao_loja.modules.product.controllers;

import br.com.api.biju.gestao_loja.modules.product.dto.ProductCreationDTO;
import br.com.api.biju.gestao_loja.modules.product.usecases.CreateProductUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
public class ProductController {

    @Autowired
    CreateProductUseCase createProductUseCase;

    @PostMapping("/create")
    public ResponseEntity<Object> createProduct(@RequestBody ProductCreationDTO productCreationDTO) {
        try {
            var response = this.createProductUseCase.execute(productCreationDTO);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

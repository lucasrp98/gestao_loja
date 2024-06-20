package br.com.api.biju.gestao_loja.modules.produto.controllers;

import br.com.api.biju.gestao_loja.modules.produto.models.ProductEntity;
import br.com.api.biju.gestao_loja.modules.produto.usecases.CreateProductUseCase;
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
    public ResponseEntity<Object> createProduct(@RequestBody ProductEntity productEntity) {
        try {
            var response = this.createProductUseCase.execute(productEntity);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

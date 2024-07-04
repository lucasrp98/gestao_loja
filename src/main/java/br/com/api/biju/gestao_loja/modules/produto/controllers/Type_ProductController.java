package br.com.api.biju.gestao_loja.modules.produto.controllers;

import br.com.api.biju.gestao_loja.modules.produto.models.ProductEntity;
import br.com.api.biju.gestao_loja.modules.produto.models.Type_ProductEntity;
import br.com.api.biju.gestao_loja.modules.produto.usecases.CreateTypeProductUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tipoproduto")
public class Type_ProductController {

    @Autowired
    CreateTypeProductUseCase createTypeProductUseCase;

    @PostMapping("/create")
    public ResponseEntity<Object> createProduct(@RequestBody Type_ProductEntity typeProductEntity) {
        try {
            var response = this.createTypeProductUseCase.execute(typeProductEntity);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

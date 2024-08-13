package br.com.api.biju.gestao_loja.modules.product.controllers;

import br.com.api.biju.gestao_loja.modules.product.dto.Type_ProductDTO;
import br.com.api.biju.gestao_loja.modules.product.models.Type_ProductEntity;
import br.com.api.biju.gestao_loja.modules.product.usecases.CreateTypeProductUseCase;
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
    public ResponseEntity<Object> createProduct(@RequestBody Type_ProductDTO typeProductDTO) {
        try {
            Type_ProductEntity typeProductEntity = typeProductDTO.toTypeProductEntity();
            var response = this.createTypeProductUseCase.execute(typeProductEntity);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

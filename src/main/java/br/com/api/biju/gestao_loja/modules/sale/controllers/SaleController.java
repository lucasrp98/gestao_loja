package br.com.api.biju.gestao_loja.modules.sale.controllers;

import br.com.api.biju.gestao_loja.modules.product.dto.ProductCreationDTO;
import br.com.api.biju.gestao_loja.modules.sale.dto.SaleDTO;
import br.com.api.biju.gestao_loja.modules.sale.useCases.CreateSaleUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/venda")
public class SaleController {

    @Autowired
    CreateSaleUseCase createSaleUseCase;

    @PostMapping("/create")
    public ResponseEntity<Object> createSale(@RequestBody SaleDTO saleDTO) {
        try {
            var response = this.createSaleUseCase.execute(saleDTO);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

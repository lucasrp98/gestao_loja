package br.com.api.biju.gestao_loja.modules.payment_method.controllers;

import br.com.api.biju.gestao_loja.modules.payment_method.dto.Payment_MethodDTO;
import br.com.api.biju.gestao_loja.modules.payment_method.models.Payment_MethodEntity;
import br.com.api.biju.gestao_loja.modules.payment_method.useCases.CreatePayment_MethodUseCase;
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
@RequestMapping("/formapagamento")
public class Payment_MethodController {

    @Autowired
    CreatePayment_MethodUseCase createPaymentMethodUseCase;

    @PostMapping("/create")
    public ResponseEntity<Object> createPayment_Method(@RequestBody Payment_MethodDTO paymentMethodDTO) {
        try {
            Payment_MethodEntity paymentMethodEntity = paymentMethodDTO.toPayment_MethodEntity();
            var response = this.createPaymentMethodUseCase.execute(paymentMethodEntity);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

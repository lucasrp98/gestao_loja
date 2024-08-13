package br.com.api.biju.gestao_loja.modules.payment_method.dto;

import br.com.api.biju.gestao_loja.modules.payment_method.models.Payment_MethodEntity;
import br.com.api.biju.gestao_loja.modules.product.models.Type_ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment_MethodDTO {
    private String nome;

    public Payment_MethodEntity toPayment_MethodEntity() {
        Payment_MethodEntity paymentMethodEntity = new Payment_MethodEntity();
        paymentMethodEntity.setNome(this.nome);
        return paymentMethodEntity;
    }
}

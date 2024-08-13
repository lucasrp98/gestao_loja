package br.com.api.biju.gestao_loja.modules.payment_method.useCases;

import br.com.api.biju.gestao_loja.modules.exceptions.PaymentMethodExceptions;
import br.com.api.biju.gestao_loja.modules.exceptions.ProductExceptions;
import br.com.api.biju.gestao_loja.modules.payment_method.models.Payment_MethodEntity;
import br.com.api.biju.gestao_loja.modules.payment_method.repositories.Payment_MethodRepository;
import br.com.api.biju.gestao_loja.modules.product.models.Type_ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreatePayment_MethodUseCase {

    @Autowired
    Payment_MethodRepository paymentMethodRepository;

    public Payment_MethodEntity execute(Payment_MethodEntity paymentMethodEntity){
        this.paymentMethodRepository
                .findByNome(paymentMethodEntity.getNome())
                .ifPresent((typeProduct) -> {
                    throw new PaymentMethodExceptions.PaymentMethodException();
                });
        return this.paymentMethodRepository.save(paymentMethodEntity);
    }
}

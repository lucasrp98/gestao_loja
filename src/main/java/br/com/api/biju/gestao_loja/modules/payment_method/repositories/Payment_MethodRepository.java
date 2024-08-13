package br.com.api.biju.gestao_loja.modules.payment_method.repositories;

import br.com.api.biju.gestao_loja.modules.payment_method.models.Payment_MethodEntity;
import br.com.api.biju.gestao_loja.modules.product.models.Type_ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Payment_MethodRepository extends JpaRepository<Payment_MethodEntity, Integer> {
    Optional<Payment_MethodEntity> findByNome(String nome);

}

package br.com.api.biju.gestao_loja.modules.sale.repositories;

import br.com.api.biju.gestao_loja.modules.product.models.ProductEntity;
import br.com.api.biju.gestao_loja.modules.product.models.Type_ProductEntity;
import br.com.api.biju.gestao_loja.modules.sale.models.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SaleRepository extends JpaRepository<SaleEntity, Integer> {
    Optional<SaleEntity> findById(Integer idSale);

}

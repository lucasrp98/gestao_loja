package br.com.api.biju.gestao_loja.modules.product.repositories;


import br.com.api.biju.gestao_loja.modules.product.models.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    Optional<ProductEntity> findByNome(String nome);
    Optional<ProductEntity> findById(Integer idProduct);

    Optional<ProductEntity> findAllById(Integer idProduct);

}

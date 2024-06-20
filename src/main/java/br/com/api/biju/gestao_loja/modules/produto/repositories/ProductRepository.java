package br.com.api.biju.gestao_loja.modules.produto.repositories;


import br.com.api.biju.gestao_loja.modules.produto.models.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    Optional<ProductEntity> findByNome(String nome);
}

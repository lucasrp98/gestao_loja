package br.com.api.biju.gestao_loja.modules.produto.repositories;

import br.com.api.biju.gestao_loja.modules.produto.models.ProductEntity;
import br.com.api.biju.gestao_loja.modules.produto.models.Type_ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Type_ProductRepository extends JpaRepository<Type_ProductEntity, Integer> {
    Optional<Type_ProductEntity> findByNome(String nome);

}

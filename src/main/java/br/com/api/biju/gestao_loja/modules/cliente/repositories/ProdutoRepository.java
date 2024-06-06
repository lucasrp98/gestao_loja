package br.com.api.biju.gestao_loja.modules.cliente.repositories;


import br.com.api.biju.gestao_loja.modules.cliente.models.produto.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Integer> {
    Optional<ProdutoEntity> findByNome(String nome);
}

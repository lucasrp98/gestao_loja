package br.com.api.biju.gestao_loja.modules.cliente.repositories;

import br.com.api.biju.gestao_loja.modules.cliente.models.peca.PecaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PecaRepository extends JpaRepository<PecaEntity, Integer> {

    Optional<PecaEntity> findByNome(String nome);
    Optional<PecaEntity> findById(Integer id);

}

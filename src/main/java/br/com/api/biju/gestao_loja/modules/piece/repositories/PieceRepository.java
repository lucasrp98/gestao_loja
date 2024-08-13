package br.com.api.biju.gestao_loja.modules.piece.repositories;

import br.com.api.biju.gestao_loja.modules.piece.models.PieceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PieceRepository extends JpaRepository<PieceEntity, Integer> {

    Optional<PieceEntity> findByNome(String nome);
    Optional<PieceEntity> findById(Integer id);

}

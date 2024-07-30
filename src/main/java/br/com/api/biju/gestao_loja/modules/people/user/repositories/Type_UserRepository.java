package br.com.api.biju.gestao_loja.modules.people.user.repositories;

import br.com.api.biju.gestao_loja.modules.people.user.models.Type_UserEntity;
import br.com.api.biju.gestao_loja.modules.produto.models.Type_ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Type_UserRepository extends JpaRepository<Type_UserEntity, Integer> {
    Optional<Type_UserEntity> findBydescricao(String nome);
    Optional<Type_UserEntity> findById(Integer idTypeProduct);
}

package br.com.api.biju.gestao_loja.modules.cliente.repositories;


import br.com.api.biju.gestao_loja.modules.cliente.models.people.ClientEntity;
import br.com.api.biju.gestao_loja.modules.cliente.models.people.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findBycpf(String cpf);
}

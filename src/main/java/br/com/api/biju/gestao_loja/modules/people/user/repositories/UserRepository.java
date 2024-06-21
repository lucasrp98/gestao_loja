package br.com.api.biju.gestao_loja.modules.people.user.repositories;


import br.com.api.biju.gestao_loja.modules.people.user.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findBycpf(String cpf);
    Optional<UserEntity> findByemail(String email);

}

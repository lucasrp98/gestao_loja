package br.com.api.biju.gestao_loja.modules.cliente.useCases.user;

import br.com.api.biju.gestao_loja.modules.cliente.exceptions.UserExceptions;
import br.com.api.biju.gestao_loja.modules.cliente.models.people.UserEntity;
import br.com.api.biju.gestao_loja.modules.cliente.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCase {

    @Autowired
    private PeopleRepository peopleRepository;

    public UserEntity execute(UserEntity userEntity) {
        this.peopleRepository
                .findBycpf(userEntity.getCpf())
                .ifPresent((user) -> {
                    throw new UserExceptions.UserFoundException();
                });
        return this.peopleRepository.save(userEntity);
    }
}

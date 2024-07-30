package br.com.api.biju.gestao_loja.modules.people.user.usecases;

import br.com.api.biju.gestao_loja.modules.exceptions.ProductExceptions;
import br.com.api.biju.gestao_loja.modules.exceptions.UserExceptions;
import br.com.api.biju.gestao_loja.modules.people.user.models.Type_UserEntity;
import br.com.api.biju.gestao_loja.modules.people.user.repositories.Type_UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateTypeUserUseCase {

    @Autowired
    Type_UserRepository typeUserRepository;

    public Type_UserEntity execute(Type_UserEntity typeUserEntity) {
        this.typeUserRepository
                .findBydescricao(typeUserEntity.getDescricao())
                .ifPresent((typeUser) -> {
                    throw new UserExceptions.TypeUserFoundException();
                });
        return this.typeUserRepository.save(typeUserEntity);
    }
}

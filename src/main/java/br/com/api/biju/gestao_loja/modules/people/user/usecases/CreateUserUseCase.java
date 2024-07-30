package br.com.api.biju.gestao_loja.modules.people.user.usecases;

import br.com.api.biju.gestao_loja.modules.exceptions.ProductExceptions;
import br.com.api.biju.gestao_loja.modules.exceptions.UserExceptions;
import br.com.api.biju.gestao_loja.modules.people.user.dto.UserCreateDTO;
import br.com.api.biju.gestao_loja.modules.people.user.models.Type_UserEntity;
import br.com.api.biju.gestao_loja.modules.people.user.models.UserEntity;
import br.com.api.biju.gestao_loja.modules.people.user.repositories.Type_UserRepository;
import br.com.api.biju.gestao_loja.modules.people.user.repositories.UserRepository;
import br.com.api.biju.gestao_loja.modules.produto.models.Type_ProductEntity;
import br.com.api.biju.gestao_loja.modules.produto.repositories.Type_ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCase {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    Type_UserRepository typeUserRepository;

    public UserEntity execute(UserCreateDTO userCreateDTO) {
        Type_UserEntity typeUserEntity = toCheckTypeUser(userCreateDTO.getTipoUserId());
        UserEntity userEntity = userCreateDTO.toUserEntity(typeUserEntity);
        this.userRepository
                .findBycpf(userEntity.getCpf())
                .ifPresent((user) -> {
                    throw new UserExceptions.UserFoundException();
                });

        var password = passwordEncoder.encode(userEntity.getPassword());
        userEntity.setPassword(password);
        return this.userRepository.save(userEntity);
    }

    private Type_UserEntity toCheckTypeUser(Integer idTypeProduct) {
        return this.typeUserRepository.findById(idTypeProduct)
                .orElseThrow(() -> new UserExceptions.TypeUserNotFoundException());
    }
}

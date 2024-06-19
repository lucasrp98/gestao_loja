package br.com.api.biju.gestao_loja.modules.cliente.useCases.user;

import br.com.api.biju.gestao_loja.modules.cliente.exceptions.UserExceptions;
import br.com.api.biju.gestao_loja.modules.cliente.models.people.UserEntity;
import br.com.api.biju.gestao_loja.modules.cliente.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCase {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserEntity execute(UserEntity userEntity) {
        this.userRepository
                .findBycpf(userEntity.getCpf())
                .ifPresent((user) -> {
                    throw new UserExceptions.UserFoundException();
                });

        var password = passwordEncoder.encode(userEntity.getPassword());
        userEntity.setPassword(password);
        return this.userRepository.save(userEntity);
    }
}

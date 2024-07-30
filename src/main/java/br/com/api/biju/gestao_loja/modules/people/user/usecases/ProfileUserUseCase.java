package br.com.api.biju.gestao_loja.modules.people.user.usecases;

import br.com.api.biju.gestao_loja.modules.exceptions.UserExceptions;
import br.com.api.biju.gestao_loja.modules.people.user.dto.ProfileUserResponseDTO;
import br.com.api.biju.gestao_loja.modules.people.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileUserUseCase {

    @Autowired
    private UserRepository userRepository;

    public ProfileUserResponseDTO execute(Integer idUser) {
        var user = this.userRepository.findByid(idUser)
                .orElseThrow(() -> {
                    throw new UserExceptions.UserFoundException();
                });
        var userDTO = ProfileUserResponseDTO.builder()
                .name(user.getName())
                .email(user.getEmail())
                .user_type(String.valueOf(user.getUser_type()))
                .build();

        return userDTO;
    }
}

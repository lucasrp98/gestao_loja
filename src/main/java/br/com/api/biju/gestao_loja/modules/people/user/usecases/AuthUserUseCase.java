package br.com.api.biju.gestao_loja.modules.people.user.usecases;

import br.com.api.biju.gestao_loja.modules.exceptions.UserExceptions;
import br.com.api.biju.gestao_loja.modules.people.user.dto.AuthUserDTO;
import br.com.api.biju.gestao_loja.modules.people.user.models.UserEntity;
import br.com.api.biju.gestao_loja.modules.people.user.repositories.UserRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;

@Service
public class AuthUserUseCase {
    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${security.token.secret}")
    private String secretKey;

    public String execute(AuthUserDTO authUserDTO) throws AuthenticationException {
        var user = this.userRepository.findByemail(authUserDTO.getEmail()).orElseThrow(
                () -> {
                    throw new UserExceptions.UserNotFoundException();
                }
        );
        var passwordMatches = passwordEncoder.matches(authUserDTO.getPassword(), user.getPassword());

        if (!passwordMatches) {
            throw new AuthenticationException("Senha incorreta");
        }
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        var token = JWT.create().withIssuer("dorabiju")
                .withExpiresAt(Instant.now().plus(Duration.ofHours(2)))
                .withSubject(String.valueOf(user.getId()))
                .sign(algorithm);
        return token;
    }
}

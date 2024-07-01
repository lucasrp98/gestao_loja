package br.com.api.biju.gestao_loja.modules.people.user.usecases;

import br.com.api.biju.gestao_loja.modules.exceptions.UserExceptions;
import br.com.api.biju.gestao_loja.modules.people.user.dto.AuthUserRequestDTO;
import br.com.api.biju.gestao_loja.modules.people.user.dto.AuthUserResponseDTO;
import br.com.api.biju.gestao_loja.modules.people.user.repositories.UserRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

@Service
public class AuthUserUseCase {
    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${security.token.secret}")
    private String secretKey;

    public AuthUserResponseDTO execute(AuthUserRequestDTO authUserRequestDTO) throws AuthenticationException {
        var user = this.userRepository.findByemail(authUserRequestDTO.email()).orElseThrow(
                () -> {
                    throw new UserExceptions.UserNotFoundException();
                }
        );
        var passwordMatches = passwordEncoder.matches(authUserRequestDTO.password(), user.getPassword());

        if (!passwordMatches) {
            throw new AuthenticationException("Senha incorreta");
        }
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        var expiresIn = Instant.now().plus(Duration.ofMinutes(10));
        var token = JWT.create().withIssuer("dorabiju")
                .withExpiresAt(expiresIn)
                .withSubject(String.valueOf(user.getUser_type()))
                .withClaim("roles", Arrays.asList(user.getUser_type()))
                .sign(algorithm);

        var authUserResponse = AuthUserResponseDTO.builder()
                .acess_token(token)
                .expires_in(expiresIn.toEpochMilli())
                .build();

        return authUserResponse;
    }
}

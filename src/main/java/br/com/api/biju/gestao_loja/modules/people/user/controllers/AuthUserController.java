package br.com.api.biju.gestao_loja.modules.people.user.controllers;

import br.com.api.biju.gestao_loja.modules.exceptions.UserExceptions;
import br.com.api.biju.gestao_loja.modules.people.user.dto.AuthUserRequestDTO;
import br.com.api.biju.gestao_loja.modules.people.user.usecases.AuthUserUseCase;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthUserController {

    @Autowired
    AuthUserUseCase authUserUseCase;

    @PostMapping("/user")
    public ResponseEntity<Object> create (@RequestBody AuthUserRequestDTO authUserRequestDTO) throws AuthenticationException {
        try {
            var result = this.authUserUseCase.execute(authUserRequestDTO);
            return ResponseEntity.ok(result);

        } catch (UserExceptions.UserNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("E-mail não encontrado");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("E-mail ou senha incorreto.");
        }
    }
}

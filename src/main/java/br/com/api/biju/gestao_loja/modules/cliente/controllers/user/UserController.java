package br.com.api.biju.gestao_loja.modules.cliente.controllers.user;


import br.com.api.biju.gestao_loja.modules.cliente.models.people.UserEntity;
import br.com.api.biju.gestao_loja.modules.cliente.useCases.user.CreateUserUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private CreateUserUseCase createUserUseCase;

    @PostMapping("/create")
    public ResponseEntity<Object> create(@Valid @RequestBody UserEntity userEntity){
        try {
            var response = this.createUserUseCase.execute(userEntity);
            return ResponseEntity.ok().body(response);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

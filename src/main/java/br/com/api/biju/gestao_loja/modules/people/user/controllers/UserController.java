package br.com.api.biju.gestao_loja.modules.people.user.controllers;


import br.com.api.biju.gestao_loja.modules.people.user.models.UserEntity;
import br.com.api.biju.gestao_loja.modules.people.user.usecases.CreateUserUseCase;
import br.com.api.biju.gestao_loja.modules.people.user.usecases.ProfileUserUseCase;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private CreateUserUseCase createUserUseCase;

    @Autowired
    private ProfileUserUseCase profileUserUseCase;

    @PostMapping("/create")
    public ResponseEntity<Object> create(@Valid @RequestBody UserEntity userEntity) {
        try {
            var response = this.createUserUseCase.execute(userEntity);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<Object> get(HttpServletRequest request) {

        var idUser = request.getAttribute("user_id");
        try {
            var profile = this.profileUserUseCase.execute(Integer.parseInt((String) idUser));
            return ResponseEntity.ok().body(profile);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}

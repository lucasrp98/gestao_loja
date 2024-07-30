package br.com.api.biju.gestao_loja.modules.people.user.controllers;

import br.com.api.biju.gestao_loja.modules.people.user.dto.CreateTypeUserDTO;
import br.com.api.biju.gestao_loja.modules.people.user.models.Type_UserEntity;
import br.com.api.biju.gestao_loja.modules.people.user.usecases.CreateTypeUserUseCase;
import br.com.api.biju.gestao_loja.modules.produto.models.Type_ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tipouser")
public class Type_UserController {

    @Autowired
    CreateTypeUserUseCase createTypeUserUseCase;

    @PostMapping("/create")
    public ResponseEntity<Object> createProduct(@RequestBody CreateTypeUserDTO createTypeUserDTO) {
        try {
            Type_UserEntity typeUserEntity = createTypeUserDTO.toTypeUserEntity();
            var response = this.createTypeUserUseCase.execute(typeUserEntity);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

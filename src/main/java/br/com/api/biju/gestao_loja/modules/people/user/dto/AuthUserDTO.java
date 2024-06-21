package br.com.api.biju.gestao_loja.modules.people.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthUserDTO {
    private String email;
    private String password;
}

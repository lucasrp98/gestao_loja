package br.com.api.biju.gestao_loja.modules.people.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileUserResponseDTO {

    private String name;
    private String email;
    private String user_type;
}

package br.com.api.biju.gestao_loja.modules.people.user.dto;

import br.com.api.biju.gestao_loja.modules.people.user.models.Type_UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTypeUserDTO {
    private String descricao;

    public Type_UserEntity toTypeUserEntity(){
        Type_UserEntity typeUserEntity = new Type_UserEntity();
        typeUserEntity.setDescricao(this.descricao);
        return typeUserEntity;
    }
}

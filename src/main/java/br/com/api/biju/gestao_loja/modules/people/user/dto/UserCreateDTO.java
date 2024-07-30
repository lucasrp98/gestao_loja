package br.com.api.biju.gestao_loja.modules.people.user.dto;

import br.com.api.biju.gestao_loja.modules.peca.models.CordPieceEntity;
import br.com.api.biju.gestao_loja.modules.people.user.models.Type_UserEntity;
import br.com.api.biju.gestao_loja.modules.people.user.models.UserEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserCreateDTO {
    private String name;
    private String cpf;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date data_nasc;
    private String cep;
    private String rua;
    private Integer num_casa;
    private String bairro;
    private String cidade;
    private String estado;
    private String email;
    private String password;
    private Integer tipoUserId;
    @CreationTimestamp
    private LocalDateTime createdAt;

    public UserEntity toUserEntity(Type_UserEntity typeUserEntity){
        UserEntity userEntity = new UserEntity();
        userEntity.setName(this.name);
        userEntity.setCpf(this.cpf);
        userEntity.setData_nasc(this.data_nasc);
        userEntity.setCep(this.cep);
        userEntity.setRua(this.rua);
        userEntity.setNum_casa(this.num_casa);
        userEntity.setBairro(this.bairro);
        userEntity.setCidade(this.cidade);
        userEntity.setEstado(this.estado);
        userEntity.setEmail(this.email);
        userEntity.setPassword(this.password);
        userEntity.setUser_type(typeUserEntity);
        return userEntity;
    }
}

package br.com.api.biju.gestao_loja.modules.people.user.models;

import br.com.api.biju.gestao_loja.modules.people.PeopleEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "user_loja")
public class UserEntity extends PeopleEntity {
    @Email(message = "O campo [email] deve conter um e-mail válido")
    private String email;

    @Length(message = "A senha deve conter no mínimo 8 caracterers")
    private String password;
}

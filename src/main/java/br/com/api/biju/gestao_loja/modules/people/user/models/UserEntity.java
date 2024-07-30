package br.com.api.biju.gestao_loja.modules.people.user.models;

import br.com.api.biju.gestao_loja.modules.people.PeopleEntity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "user_loja")
public class UserEntity extends PeopleEntity {
    @Email(message = "O campo [email] deve conter um e-mail válido")
    private String email;

    @Length(message = "A senha deve conter no mínimo 8 caracterers")
    private String password;
    @ManyToOne
    @JoinColumn(name = "user_type_id", nullable = false)
    private Type_UserEntity user_type;
}

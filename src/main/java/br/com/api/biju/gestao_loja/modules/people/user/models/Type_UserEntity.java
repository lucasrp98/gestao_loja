package br.com.api.biju.gestao_loja.modules.people.user.models;

import br.com.api.biju.gestao_loja.modules.peca.models.PieceEntity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tipo_usuario")
public class Type_UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "type_user_seq")
    @SequenceGenerator(name = "type_user_seq", sequenceName = "type_user_seq", allocationSize = 1)
    private int id;
    @NotBlank(message = "A descrição do tipo de usuário é obrigatória")
    private String descricao;
    @OneToMany(mappedBy = "user_type")
    private List<UserEntity> users = new ArrayList<>();


}

package br.com.api.biju.gestao_loja.modules.cliente.models.people;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Data
@Entity(name = "cliente")
public class ClientEntity extends PeopleEntity {

}



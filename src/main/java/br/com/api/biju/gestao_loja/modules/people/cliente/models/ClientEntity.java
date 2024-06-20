package br.com.api.biju.gestao_loja.modules.people.cliente.models;


import br.com.api.biju.gestao_loja.modules.people.PeopleEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
@Entity(name = "cliente")
public class ClientEntity extends PeopleEntity {

}



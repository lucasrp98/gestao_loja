package br.com.api.biju.gestao_loja.modules.people.client.models;


import br.com.api.biju.gestao_loja.modules.people.PeopleEntity;
import br.com.api.biju.gestao_loja.modules.sale.models.SaleEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "cliente")
public class ClientEntity extends PeopleEntity {
    @OneToMany(mappedBy = "clientEntity")
    @JsonManagedReference
    private List<SaleEntity> vendas;
}



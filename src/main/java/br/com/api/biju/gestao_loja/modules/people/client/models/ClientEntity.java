package br.com.api.biju.gestao_loja.modules.people.client.models;


import br.com.api.biju.gestao_loja.modules.people.PeopleEntity;
import br.com.api.biju.gestao_loja.modules.sale.models.SaleEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@Data
@Entity(name = "cliente")
public class ClientEntity extends PeopleEntity {
    @OneToMany(mappedBy = "venda_id")
    @JsonManagedReference
    private List<SaleEntity> vendas = new ArrayList<>();
}



package br.com.api.biju.gestao_loja.modules.people.seller.models;

import br.com.api.biju.gestao_loja.modules.people.PeopleEntity;
import br.com.api.biju.gestao_loja.modules.sale.models.SaleEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "vendedor")
public class SellerEntity extends PeopleEntity {
    @ManyToOne
    @JoinColumn(name = "venda_id", nullable = false)
    private SaleEntity saleEntity;
}

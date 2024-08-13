package br.com.api.biju.gestao_loja.modules.sale.models;

import br.com.api.biju.gestao_loja.modules.payment_method.models.Payment_MethodEntity;
import br.com.api.biju.gestao_loja.modules.people.client.models.ClientEntity;
import br.com.api.biju.gestao_loja.modules.people.seller.models.SellerEntity;
import br.com.api.biju.gestao_loja.modules.product.models.ProductEntity;
import br.com.api.biju.gestao_loja.modules.product.models.Type_ProductEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "venda")
public class SaleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "venda_seq")
    @SequenceGenerator(name = "venda_seq", sequenceName = "venda_seq", allocationSize = 1)
    private int id;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date data_venda;
    @DecimalMin(value = "0.1", inclusive = false, message = "O preço deve ser maior que 0")
    private double valor_venda;
    private int quantidade;
    @DecimalMin(value = "0.1", inclusive = false, message = "O preço deve ser maior que 0")
    private double valor_frete;
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private ClientEntity clientEntity;
    @ManyToOne
    @JoinColumn(name = "tipo_forma_pagamento_id", nullable = false)
    private Payment_MethodEntity paymentMethodEntity;
    @ManyToOne
    @JoinColumn(name = "vendedor_id", nullable = false)
    private SellerEntity sellerEntity;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "produto_has_venda", joinColumns = @JoinColumn(name = "sale_id"),
            inverseJoinColumns = @JoinColumn(name = "peca_id"))
    private List<ProductEntity> productEntityList;

    @CreationTimestamp
    private LocalDateTime createdAt;
}

package br.com.api.biju.gestao_loja.modules.payment_method.models;

import br.com.api.biju.gestao_loja.modules.product.models.ProductEntity;
import br.com.api.biju.gestao_loja.modules.sale.models.SaleEntity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "forma_pagamento")
public class Payment_MethodEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "forma_pag_seq")
    @SequenceGenerator(name = "forma_pag_seq", sequenceName = "forma_pag_seq", allocationSize = 1)
    private int id;
    @NotBlank(message = "O nome da forma de pagamento é obrigatório")
    @Size(max = 100, message = "O nome da forma de pagamento deve ter no máximo 100 caracteres")
    private String nome;
    @OneToMany(mappedBy = "venda_id")
    @JsonManagedReference
    private List<SaleEntity> sales = new ArrayList<>();
}

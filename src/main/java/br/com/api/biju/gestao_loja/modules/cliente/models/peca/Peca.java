package br.com.api.biju.gestao_loja.modules.cliente.models.peca;

import br.com.api.biju.gestao_loja.modules.cliente.models.produto.ProdutoEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
public abstract class Peca {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String nome;
    private int estoque;
    private double custo;
    @ManyToOne
    private ProdutoEntity produto;

}

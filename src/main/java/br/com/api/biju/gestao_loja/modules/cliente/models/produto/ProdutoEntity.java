package br.com.api.biju.gestao_loja.modules.cliente.models.produto;

import br.com.api.biju.gestao_loja.modules.cliente.models.peca.Peca;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "produto")
public class ProdutoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String nome;
    private String tipo_produto;
    private int estoque;
    private double preco;
    private double custo;

    @OneToMany
    @JoinColumn(name = "peca_id")
    private List<Peca> peca;

    @Column(name = "peca_id")
    private int pecaID;

}

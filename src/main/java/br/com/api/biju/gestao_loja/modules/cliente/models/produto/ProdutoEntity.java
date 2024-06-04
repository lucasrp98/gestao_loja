package br.com.api.biju.gestao_loja.modules.cliente.models.produto;

import br.com.api.biju.gestao_loja.modules.cliente.models.peca.PecaEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
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

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "produto_has_pecas", joinColumns = @JoinColumn(name = "produto_id"),
            inverseJoinColumns = @JoinColumn(name = "peca_id"))
    private List<PecaEntity> peca;

    @CreationTimestamp
    private LocalDateTime createdAt;

}

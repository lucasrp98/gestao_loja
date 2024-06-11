package br.com.api.biju.gestao_loja.modules.cliente.models.peca;

import br.com.api.biju.gestao_loja.modules.cliente.models.produto.ProdutoEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
public abstract class PecaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "peca_seq")
    @SequenceGenerator(name = "peca_seq", sequenceName = "peca_seq", allocationSize = 1)
    private int id;
    private String nome;
    private int estoque;
    private double custo;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "produto_has_pecas", joinColumns = @JoinColumn(name = "peca_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id"))
    private List<ProdutoEntity> produtoEntityList = new ArrayList<>();

    @CreationTimestamp
    private LocalDateTime createdAt;

}

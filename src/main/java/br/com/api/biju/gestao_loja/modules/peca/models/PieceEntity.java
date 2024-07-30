package br.com.api.biju.gestao_loja.modules.peca.models;

import br.com.api.biju.gestao_loja.modules.produto.models.ProductEntity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
public abstract class PieceEntity {
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
    private List<ProductEntity> productEntityList = new ArrayList<>();

    @CreationTimestamp
    private LocalDateTime createdAt;

}

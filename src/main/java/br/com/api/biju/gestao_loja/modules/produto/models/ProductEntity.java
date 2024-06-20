package br.com.api.biju.gestao_loja.modules.produto.models;

import br.com.api.biju.gestao_loja.modules.peca.models.PieceEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "produto")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_seq")
    @SequenceGenerator(name = "produto_seq", sequenceName = "produto_seq", allocationSize = 1)
    private int id;
    @NotBlank(message = "O nome é obrigatório")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
    private String nome;
    @NotBlank(message = "O tipo do produto é obrigatório")
    private String tipo_produto;
    private int estoque;
    @DecimalMin(value = "0.1", inclusive = false, message = "O preço deve ser maior que 0")
    private double preco;
    private double custo;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "produto_has_pecas", joinColumns = @JoinColumn(name = "produto_id"),
            inverseJoinColumns = @JoinColumn(name = "peca_id"))
    private List<PieceEntity> peca = new ArrayList<>();
    private List<Integer> list_pecas;


    @CreationTimestamp
    private LocalDateTime createdAt;

}

package br.com.api.biju.gestao_loja.modules.produto.dto;


import br.com.api.biju.gestao_loja.modules.peca.models.PieceEntity;
import br.com.api.biju.gestao_loja.modules.produto.models.ProductEntity;
import br.com.api.biju.gestao_loja.modules.produto.models.Type_ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductCreationDTO {
    private String nome;
    private Integer tipoProdutoId;
    private int estoque;
    private double preco;
    private double custo;
    private List<Integer> list_pecas;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public ProductEntity toProductEntity(Type_ProductEntity tipo_produto, List<PieceEntity> pecas) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setNome(this.nome);
        productEntity.setEstoque(this.estoque);
        productEntity.setPreco(this.preco);
        productEntity.setCusto(this.custo);
        productEntity.setTipo_produto(tipo_produto);
        productEntity.setPeca(pecas);
        return productEntity;
    }
}

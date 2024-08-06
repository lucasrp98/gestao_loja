package br.com.api.biju.gestao_loja.modules.produto.dto;

import br.com.api.biju.gestao_loja.modules.peca.models.PieceEntity;
import br.com.api.biju.gestao_loja.modules.produto.models.ProductEntity;
import br.com.api.biju.gestao_loja.modules.produto.models.Type_ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Type_ProductDTO {
    private String nome;

    public Type_ProductEntity toTypeProductEntity() {
        Type_ProductEntity typeProductEntity = new Type_ProductEntity();
        typeProductEntity.setNome(this.nome);
        return typeProductEntity;
    }
}

package br.com.api.biju.gestao_loja.modules.product.dto;

import br.com.api.biju.gestao_loja.modules.product.models.Type_ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

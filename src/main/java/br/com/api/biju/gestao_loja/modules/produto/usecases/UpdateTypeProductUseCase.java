package br.com.api.biju.gestao_loja.modules.produto.usecases;

import br.com.api.biju.gestao_loja.modules.exceptions.PieceExceptions;
import br.com.api.biju.gestao_loja.modules.peca.models.PieceEntity;
import br.com.api.biju.gestao_loja.modules.produto.models.ProductEntity;
import br.com.api.biju.gestao_loja.modules.produto.models.Type_ProductEntity;
import br.com.api.biju.gestao_loja.modules.produto.repositories.Type_ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UpdateTypeProductUseCase {
    private final Type_ProductRepository typeProductRepository;


    public void insertProduct(Integer typeProductId, ProductEntity productEntity) {
        Optional<Type_ProductEntity> optionalTypeProductEntity = typeProductRepository.findById(typeProductId);

        Type_ProductEntity typeProductEntity = optionalTypeProductEntity.get();
        typeProductEntity.getProdutos().add(productEntity);
        typeProductRepository.save(typeProductEntity);

    }
}

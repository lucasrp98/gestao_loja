package br.com.api.biju.gestao_loja.modules.produto.usecases;

import br.com.api.biju.gestao_loja.modules.exceptions.ProductExceptions;
import br.com.api.biju.gestao_loja.modules.produto.models.Type_ProductEntity;
import br.com.api.biju.gestao_loja.modules.produto.repositories.Type_ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateTypeProductUseCase {

    @Autowired
    Type_ProductRepository typeProductRepository;

    public Type_ProductEntity execute (Type_ProductEntity typeProductEntity){
        this.typeProductRepository
                .findByNome(typeProductEntity.getNome())
                .ifPresent((typeProduct) -> {
                    throw new ProductExceptions.TypeProductFoundException();
                });
        Type_ProductEntity typeProduct = this.typeProductRepository.save(typeProductEntity);
        return typeProduct;
    }
}

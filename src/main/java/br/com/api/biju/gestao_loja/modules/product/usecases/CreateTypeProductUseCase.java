package br.com.api.biju.gestao_loja.modules.product.usecases;

import br.com.api.biju.gestao_loja.modules.exceptions.ProductExceptions;
import br.com.api.biju.gestao_loja.modules.product.models.Type_ProductEntity;
import br.com.api.biju.gestao_loja.modules.product.repositories.Type_ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateTypeProductUseCase {

    @Autowired
    Type_ProductRepository typeProductRepository;

    public Type_ProductEntity execute(Type_ProductEntity typeProductEntity){
        this.typeProductRepository
                .findByNome(typeProductEntity.getNome())
                .ifPresent((typeProduct) -> {
                    throw new ProductExceptions.TypeProductFoundException();
                });
        return this.typeProductRepository.save(typeProductEntity);
    }
}

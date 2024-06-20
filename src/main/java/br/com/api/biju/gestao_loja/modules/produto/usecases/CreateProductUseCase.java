package br.com.api.biju.gestao_loja.modules.produto.usecases;

import br.com.api.biju.gestao_loja.modules.exceptions.PieceExceptions;
import br.com.api.biju.gestao_loja.modules.exceptions.ProductExceptions.ProdutoFoundException;
import br.com.api.biju.gestao_loja.modules.peca.models.PieceEntity;
import br.com.api.biju.gestao_loja.modules.produto.models.ProductEntity;
import br.com.api.biju.gestao_loja.modules.peca.repositories.PieceRepository;
import br.com.api.biju.gestao_loja.modules.produto.repositories.ProductRepository;
import br.com.api.biju.gestao_loja.modules.peca.usecases.UpdatePieceUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateProductUseCase {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    PieceRepository pieceRepository;

    @Autowired
    UpdatePieceUseCase updatePieceUseCase;


    public ProductEntity execute(ProductEntity productEntity) {
        ToCheckPecaExists(productEntity);
        this.productRepository
                .findByNome(productEntity.getNome())
                .ifPresent((produto) -> {
                    throw new ProdutoFoundException();
                });
        ProductEntity savedProductEntity = this.productRepository.save(productEntity);
        updatePieceUseCase.insertProduct(productEntity.getList_pecas(), productEntity);
        return this.productRepository.save(productEntity);
    }

    public void ToCheckPecaExists(ProductEntity productEntity) {
        for (PieceEntity peca : productEntity.getPeca()) {
            this.pieceRepository.findById(peca.getId())
                    .orElseThrow(() -> new PieceExceptions.PecaFoundException());
        }
    }
}

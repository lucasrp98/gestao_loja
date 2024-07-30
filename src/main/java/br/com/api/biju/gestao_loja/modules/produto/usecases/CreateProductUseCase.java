package br.com.api.biju.gestao_loja.modules.produto.usecases;

import br.com.api.biju.gestao_loja.modules.exceptions.PieceExceptions;
import br.com.api.biju.gestao_loja.modules.exceptions.ProductExceptions;
import br.com.api.biju.gestao_loja.modules.exceptions.ProductExceptions.ProdutoFoundException;
import br.com.api.biju.gestao_loja.modules.peca.models.PieceEntity;
import br.com.api.biju.gestao_loja.modules.produto.dto.ProductCreationDTO;
import br.com.api.biju.gestao_loja.modules.produto.models.ProductEntity;
import br.com.api.biju.gestao_loja.modules.peca.repositories.PieceRepository;
import br.com.api.biju.gestao_loja.modules.produto.models.Type_ProductEntity;
import br.com.api.biju.gestao_loja.modules.produto.repositories.ProductRepository;
import br.com.api.biju.gestao_loja.modules.produto.repositories.Type_ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreateProductUseCase {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    PieceRepository pieceRepository;

    @Autowired
    Type_ProductRepository typeProductRepository;


    public ProductEntity execute(ProductCreationDTO productCreationDTO) {
        Type_ProductEntity tipo_produto = toCheckTypeProduct(productCreationDTO.getTipoProdutoId());
        List<PieceEntity> pecas = toCheckPecaExists(productCreationDTO.getList_pecas());
        List<Integer> pecaIds = productCreationDTO.getList_pecas();

        ProductEntity productEntity = productCreationDTO.toProductEntity(tipo_produto, pecas);

        this.productRepository
                .findByNome(productEntity.getNome())
                .ifPresent((produto) -> {
                    throw new ProdutoFoundException();
                });
        ProductEntity savedProductEntity = this.productRepository.save(productEntity);
        return this.productRepository.save(savedProductEntity);
    }

    public List<PieceEntity> toCheckPecaExists(List<Integer> list_pecas) {
        List<PieceEntity> pecas = pieceRepository.findAllById(list_pecas);

        if (pecas.size() != list_pecas.size()) {
            throw new PieceExceptions.PecaNotFoundException();
        }
        return pecas;
    }

    private Type_ProductEntity toCheckTypeProduct(Integer idTypeProduct) {
        return this.typeProductRepository.findById(idTypeProduct)
                .orElseThrow(() -> new ProductExceptions.TypeProductNotFoundException());
    }
}

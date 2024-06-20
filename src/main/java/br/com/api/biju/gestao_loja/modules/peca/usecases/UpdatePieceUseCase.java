package br.com.api.biju.gestao_loja.modules.peca.usecases;

import br.com.api.biju.gestao_loja.modules.exceptions.PieceExceptions;
import br.com.api.biju.gestao_loja.modules.peca.models.PieceEntity;
import br.com.api.biju.gestao_loja.modules.produto.models.ProductEntity;
import br.com.api.biju.gestao_loja.modules.peca.repositories.PieceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UpdatePieceUseCase {

    private final PieceRepository pieceRepository;


    public void insertProduct(List<Integer> pecaIds, ProductEntity productEntity) {
        for (int pecaId : pecaIds) {
            Optional<PieceEntity> optionalPeca = pieceRepository.findById(pecaId);
            if (!optionalPeca.isPresent()) {
                throw new PieceExceptions.PecaNotFoundException();
            }
            PieceEntity peca = optionalPeca.get();
            peca.getProductEntityList().add(productEntity);
            pieceRepository.save(peca);
        }
    }
}

package br.com.api.biju.gestao_loja.modules.peca.usecases;

import br.com.api.biju.gestao_loja.modules.exceptions.PieceExceptions;
import br.com.api.biju.gestao_loja.modules.peca.models.PieceEntity;
import br.com.api.biju.gestao_loja.modules.peca.repositories.PieceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreatePieceUseCase {

    @Autowired
    private PieceRepository pieceRepository;


    public PieceEntity execute(PieceEntity pieceEntity) {
        this.pieceRepository
                .findByNome(pieceEntity.getNome())
                .ifPresent((peca) -> {
                    throw new PieceExceptions.PecaFoundException();
                });
        return this.pieceRepository.save(pieceEntity);
    }

}

package br.com.api.biju.gestao_loja.modules.cliente.useCases.peca;

import br.com.api.biju.gestao_loja.modules.cliente.exceptions.PecaFoundException;
import br.com.api.biju.gestao_loja.modules.cliente.models.peca.PecaEntity;
import br.com.api.biju.gestao_loja.modules.cliente.models.produto.ProdutoEntity;
import br.com.api.biju.gestao_loja.modules.cliente.repositories.PecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CreatePecaUseCase {

    @Autowired
    private PecaRepository pecaRepository;


    public PecaEntity execute(PecaEntity pecaEntity) {
        this.pecaRepository
                .findByNome(pecaEntity.getNome())
                .ifPresent((peca) -> {
                    throw new PecaFoundException();
                });
        return this.pecaRepository.save(pecaEntity);
    }

}

package br.com.api.biju.gestao_loja.modules.cliente.useCases.produto;

import br.com.api.biju.gestao_loja.modules.cliente.exceptions.PecaFoundException;
import br.com.api.biju.gestao_loja.modules.cliente.exceptions.ProdutoFoundException;
import br.com.api.biju.gestao_loja.modules.cliente.models.peca.PecaEntity;
import br.com.api.biju.gestao_loja.modules.cliente.models.produto.ProdutoEntity;
import br.com.api.biju.gestao_loja.modules.cliente.repositories.PecaRepository;
import br.com.api.biju.gestao_loja.modules.cliente.repositories.ProdutoRepository;
import br.com.api.biju.gestao_loja.modules.cliente.useCases.peca.UpdatePecaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateProdutoUseCase {

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    PecaRepository pecaRepository;

    @Autowired
    UpdatePecaUseCase updatePecaUseCase;


    public ProdutoEntity execute(ProdutoEntity produtoEntity) {
        ToCheckPecaExists(produtoEntity);
        this.produtoRepository
                .findByNome(produtoEntity.getNome())
                .ifPresent((produto) -> {
                    throw new ProdutoFoundException();
                });
        ProdutoEntity savedProdutoEntity = this.produtoRepository.save(produtoEntity);
        updatePecaUseCase.insertProduct(produtoEntity.getList_pecas(), produtoEntity);
        return this.produtoRepository.save(produtoEntity);
    }

    public void ToCheckPecaExists(ProdutoEntity produtoEntity) {
        for (PecaEntity peca : produtoEntity.getPeca()) {
            this.pecaRepository.findById(peca.getId())
                    .orElseThrow(() -> new PecaFoundException());
        }
    }
}

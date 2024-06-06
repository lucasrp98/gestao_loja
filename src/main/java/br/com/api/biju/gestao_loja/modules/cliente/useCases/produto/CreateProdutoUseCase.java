package br.com.api.biju.gestao_loja.modules.cliente.useCases.produto;

import br.com.api.biju.gestao_loja.modules.cliente.exceptions.ProdutoFoundException;
import br.com.api.biju.gestao_loja.modules.cliente.models.produto.ProdutoEntity;
import br.com.api.biju.gestao_loja.modules.cliente.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateProdutoUseCase {

    @Autowired
    ProdutoRepository produtoRepository;

    public ProdutoEntity execute(ProdutoEntity produtoEntity) {
        this.produtoRepository
                .findByNome(produtoEntity.getNome())
                .ifPresent((produto) -> {
                    throw new ProdutoFoundException();
                });
        return this.produtoRepository.save(produtoEntity);
    }
}

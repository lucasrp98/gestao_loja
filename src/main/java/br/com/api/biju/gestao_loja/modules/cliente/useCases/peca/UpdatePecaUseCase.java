package br.com.api.biju.gestao_loja.modules.cliente.useCases.peca;

import br.com.api.biju.gestao_loja.modules.cliente.exceptions.PecaFoundException;
import br.com.api.biju.gestao_loja.modules.cliente.models.peca.PecaEntity;
import br.com.api.biju.gestao_loja.modules.cliente.models.produto.ProdutoEntity;
import br.com.api.biju.gestao_loja.modules.cliente.repositories.PecaRepository;
import br.com.api.biju.gestao_loja.modules.cliente.repositories.ProdutoRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UpdatePecaUseCase {

    private final PecaRepository pecaRepository;


    public void insertProduct(List<Integer> pecaIds, ProdutoEntity produtoEntity) {
        for (int pecaId : pecaIds) {
            Optional<PecaEntity> optionalPeca = pecaRepository.findById(pecaId);
            if (!optionalPeca.isPresent()) {
                throw new PecaFoundException();
            }
            PecaEntity peca = optionalPeca.get();
            peca.getProdutoEntityList().add(produtoEntity);
            pecaRepository.save(peca);
        }
    }
}

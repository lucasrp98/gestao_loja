package br.com.api.biju.gestao_loja.modules.people.seller.useCases;

import br.com.api.biju.gestao_loja.modules.exceptions.ClientExceptions;
import br.com.api.biju.gestao_loja.modules.people.client.models.ClientEntity;
import br.com.api.biju.gestao_loja.modules.people.seller.models.SellerEntity;
import br.com.api.biju.gestao_loja.modules.people.seller.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateSellerUseCase {
    @Autowired
    private SellerRepository sellerRepository;

    public SellerEntity execute(SellerEntity sellerEntity){
        this.sellerRepository
                .findBycpf(sellerEntity.getCpf())
                .ifPresent((cliente) -> {
                    throw new ClientExceptions.ClientFoundException();
                });
        return this.sellerRepository.save(sellerEntity);
    }
}

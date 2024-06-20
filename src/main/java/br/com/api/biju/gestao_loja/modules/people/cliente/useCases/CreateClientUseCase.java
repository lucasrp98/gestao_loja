package br.com.api.biju.gestao_loja.modules.people.cliente.useCases;

import br.com.api.biju.gestao_loja.modules.exceptions.ClientExceptions;
import br.com.api.biju.gestao_loja.modules.people.cliente.models.ClientEntity;
import br.com.api.biju.gestao_loja.modules.people.cliente.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateClientUseCase {

    @Autowired
    private ClientRepository clientRepository;

    public ClientEntity execute(ClientEntity clientEntity){
        this.clientRepository
                .findBycpf(clientEntity.getCpf())
                .ifPresent((cliente) -> {
                    throw new ClientExceptions.ClientFoundException();
                });
        return this.clientRepository.save(clientEntity);
    }

}

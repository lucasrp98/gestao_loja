package br.com.api.biju.gestao_loja.modules.cliente.useCases.cliente;

import br.com.api.biju.gestao_loja.modules.cliente.exceptions.ClientExceptions;
import br.com.api.biju.gestao_loja.modules.cliente.models.cliente.ClientEntity;
import br.com.api.biju.gestao_loja.modules.cliente.repositories.ClientRepository;
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
                    throw new ClientExceptions.UserFoundException();
                });
        return this.clientRepository.save(clientEntity);
    }

}

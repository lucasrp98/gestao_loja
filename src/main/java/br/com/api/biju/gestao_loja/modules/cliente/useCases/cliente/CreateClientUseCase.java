package br.com.api.biju.gestao_loja.modules.cliente.useCases.cliente;

import br.com.api.biju.gestao_loja.modules.cliente.exceptions.ClientExceptions;
import br.com.api.biju.gestao_loja.modules.cliente.models.people.ClientEntity;
import br.com.api.biju.gestao_loja.modules.cliente.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateClientUseCase {

    @Autowired
    private PeopleRepository peopleRepository;

    public ClientEntity execute(ClientEntity clientEntity){
        this.peopleRepository
                .findBycpf(clientEntity.getCpf())
                .ifPresent((cliente) -> {
                    throw new ClientExceptions.ClientFoundException();
                });
        return this.peopleRepository.save(clientEntity);
    }

}

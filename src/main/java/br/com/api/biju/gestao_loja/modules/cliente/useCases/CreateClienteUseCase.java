package br.com.api.biju.gestao_loja.modules.cliente.useCases;

import br.com.api.biju.gestao_loja.modules.cliente.exceptions.UserFoundException;
import br.com.api.biju.gestao_loja.modules.cliente.models.ClienteEntity;
import br.com.api.biju.gestao_loja.modules.cliente.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateClienteUseCase {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteEntity execute(ClienteEntity clienteEntity){
        this.clienteRepository
                .findBycpf(clienteEntity.getCpf())
                .ifPresent((cliente) -> {
                    throw new UserFoundException();
                });
        return this.clienteRepository.save(clienteEntity);
    }

}

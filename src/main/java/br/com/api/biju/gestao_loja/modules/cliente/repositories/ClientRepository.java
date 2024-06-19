package br.com.api.biju.gestao_loja.modules.cliente.repositories;

import br.com.api.biju.gestao_loja.modules.cliente.models.people.ClientEntity;
import br.com.api.biju.gestao_loja.modules.cliente.models.people.PeopleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository <ClientEntity, Integer>{

    Optional<ClientEntity> findBycpf(String cpf);

    }

package br.com.api.biju.gestao_loja.modules.people.cliente.repositories;

import br.com.api.biju.gestao_loja.modules.people.cliente.models.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository <ClientEntity, Integer>{

    Optional<ClientEntity> findBycpf(String cpf);

    }

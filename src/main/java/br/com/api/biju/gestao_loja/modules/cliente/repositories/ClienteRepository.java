package br.com.api.biju.gestao_loja.modules.cliente.repositories;

import br.com.api.biju.gestao_loja.modules.cliente.models.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ClienteRepository extends JpaRepository <ClienteEntity, UUID>{

    Optional<ClienteEntity> findBycpf(String cpf);

    }

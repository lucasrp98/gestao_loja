package br.com.api.biju.gestao_loja.modules.people.client.repositories;

import br.com.api.biju.gestao_loja.modules.people.client.models.ClientEntity;
import br.com.api.biju.gestao_loja.modules.product.models.Type_ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository <ClientEntity, Integer>{

    Optional<ClientEntity> findBycpf(String cpf);
    Optional<ClientEntity> findById(Integer idClient);


}

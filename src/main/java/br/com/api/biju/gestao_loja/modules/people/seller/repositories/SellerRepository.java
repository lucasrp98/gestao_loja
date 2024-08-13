package br.com.api.biju.gestao_loja.modules.people.seller.repositories;


import br.com.api.biju.gestao_loja.modules.people.seller.models.SellerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SellerRepository extends JpaRepository<SellerEntity, Integer> {
    Optional<SellerEntity> findBycpf(String cpf);
}

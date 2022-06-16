package com.api.organograma.repositories;

import com.api.organograma.models.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Integer> {
    boolean existsByResponsavel(String responsavel);
}

package com.api.organograma.repositories;

import com.api.organograma.models.NucleoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NucleoRepository extends JpaRepository<NucleoModel, Integer> {
    boolean existsByNome(String nome);
}
